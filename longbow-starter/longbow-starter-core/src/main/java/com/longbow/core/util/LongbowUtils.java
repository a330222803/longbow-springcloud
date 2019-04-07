package com.longbow.core.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.longbow.core.domain.DiffInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import javax.money.format.MonetaryAmountFormat;
import javax.money.format.MonetaryFormats;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

/**
 * 项目中需要使用的一些工具类
 * Created by zhangbin on 2016/6/2.
 */
@Slf4j
public final class LongbowUtils {

    public final static SimpleDateFormat DATE_FORMAT_LONG = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public final static SimpleDateFormat DATE_FORMAT_SHORT = new SimpleDateFormat("yyyy-MM-dd");
    public final static SimpleDateFormat DATE_FORMAT_SHORT_SIMPLE = new SimpleDateFormat("yyyyMMdd");
    public final static SimpleDateFormat DATE_FORMAT_LONG_SIMPLE = new SimpleDateFormat("yyyyMMddHHmmss");
    public final static MonetaryAmountFormat CNY_FORMAT = MonetaryFormats.getAmountFormat(Locale.CHINA);

    public final static ObjectMapper objectMapper = new ObjectMapper();

    //TODO:通过RestTemplateBuilder来初始化，然后设置例如超时时间之类的属性
    public final static RestTemplate restTemplate;

    private final static Integer TIMEOUT_REST = 60000 * 15;

    static {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS, true);
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.setDateFormat(DATE_FORMAT_LONG);
        objectMapper.configure(JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS,true);

        HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        httpRequestFactory.setConnectionRequestTimeout(TIMEOUT_REST);
        httpRequestFactory.setConnectTimeout(TIMEOUT_REST);
        httpRequestFactory.setReadTimeout(TIMEOUT_REST);

        restTemplate = new RestTemplate(httpRequestFactory);
        restTemplate.getMessageConverters().forEach(a -> {
            if (a instanceof MappingJackson2HttpMessageConverter) {
                MappingJackson2HttpMessageConverter covert = (MappingJackson2HttpMessageConverter) a;
                covert.setObjectMapper(objectMapper);
            }
        });
    }

    /**
     * 加密字符串
     *
     * @param s 需要加密字符串
     * @return 加密后的结果
     */
    public static String enCrypt(String s) {
        return s;
    }

    /**
     * 解密字符串
     *
     * @param s 需要解密的字符串
     * @return 解密后的结果
     */
    public static String deCrypt(String s) {
        return s;
    }

    /**
     * 对象的比较，获取属性的不同
     *
     * @param o1 比较对象1
     * @param o2 比较对象
     * @return 结果
     */
    public static Object objectDiff(Object o1, Object o2, String ignore) throws RuntimeException {
        Objects.requireNonNull(o1);
        Objects.requireNonNull(o2);
        try {
            if (o1.getClass().getName().equals(o2.getClass().getName())) {
                List<Field> fields = new ArrayList<>();
                List<DiffInfo> l = new ArrayList<>();
                Class cla = o1.getClass();
                while (cla != null) {
                    fields.addAll(Arrays.asList(cla.getDeclaredFields()));
                    cla = cla.getSuperclass();
                }
                Object f1, f2;
                for (Field field : fields) {
                    if (ignore.contains(field.getName()))
                        continue;
                    field.setAccessible(true);
                    f1 = (field.get(o1) + "").replaceAll("null", "");
                    f2 = (field.get(o2) + "").replaceAll("null", "");
                    if (!f1.equals(f2)) {
                        l.add(new DiffInfo(field.getName(), f1, f2));
                    }
                    field.setAccessible(false);
                }
                return l;
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return o1;
    }

    /**
     * string转为数字数组
     *
     * @param s 数组
     * @return 结果
     */
    public static Long[] covertToLong(String[] s) {
        if (s == null || s.length == 0) {
            return null;
        }
        Long[] last = new Long[s.length];
        int i = 0;
        for (String a : s) {
            last[i] = Long.parseLong(a);
            i++;
        }
        return last;
    }

    public static List<String> getIgnoreProperties(Object srcObject, Object destObject) {
        Class<?> clazz = srcObject.getClass();
        Field[] fields = clazz.getDeclaredFields();
        List<String> properties = new ArrayList<>();
        for (Field field : fields) {
            String property = field.getName();
            try {
                Method method = clazz.getMethod("get" + property.substring(0, 1).toUpperCase() + property.substring(1));
                Object targetO = method.invoke(destObject);
                if (targetO == null) {
                    properties.add(property);
                    continue;
                }
                Object srcO = method.invoke(srcObject);
                if (srcO == targetO || (srcO.toString().equals(targetO.toString()))) {
                    properties.add(property);
                }
            } catch (Exception ignored) {
            }
        }
        return properties;
    }

    public static <T> T mapToBean(T dest, Map<String, Object> m) {
        if (dest != null) {
            Field[] fs = dest.getClass().getDeclaredFields();
            for (Field f : fs) {
                f.setAccessible(true);
                try {
                    f.set(dest, m.get(f.getName()));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                f.setAccessible(false);
            }
        }
        return dest;
    }

    public static long betweenDays(String a, String b) {
        if (a != null && a.length() == 8 && b != null && b.length() == 8) {
            LocalDate aa = LocalDate.of(Integer.parseInt(a.substring(0, 4)), Integer.parseInt(a.substring(4, 6)), Integer.parseInt(a.substring(6)));
            LocalDate bb = LocalDate.of(Integer.parseInt(b.substring(0, 4)), Integer.parseInt(b.substring(4, 6)), Integer.parseInt(b.substring(6)));
            return bb.toEpochDay() - aa.toEpochDay();
        }
        return -1;
    }

    public static String json2string(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 处理时间查询条件
     *
     * @param m 条件
     */
    public static void checkCreateTime(Map<String, Object> m, String name) {
        Object gt = m.get(name + "_gt");
        Object le = m.get(name + "_le");
        try {
            if (!StringUtils.isEmpty(gt) && gt.toString().length() == 10) {
                m.put(name + "_gt", LongbowUtils.DATE_FORMAT_LONG.parse(gt + " 00:00:00"));
            }
            if (!StringUtils.isEmpty(le) && le.toString().length() == 10) {
                m.put(name + "_le", LongbowUtils.DATE_FORMAT_LONG.parse(le + " 23:59:59"));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * 解析数字
     *
     * @param obj
     * @return
     */
    public static Double checkDouble(Object obj) {
        if (obj == null)
            return 0d;
        try {
            return Double.parseDouble(obj.toString());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return 0.0;
    }

    public static LocalDate date2LocalDate(Date date) {
        if (date == null) {
            return LocalDate.now();
        }
        Instant instant = date.toInstant();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        return localDateTime.toLocalDate();
    }

    public static LocalDateTime date2LocalDateTime(Date date) {
        if (date == null) {
            return LocalDateTime.now();
        }
        Instant instant = date.toInstant();
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
    }

    public static Date localDateTime2Date(LocalDateTime localDateTime) {
        Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
        return Date.from(instant);
    }

    public static String leadingZero(int size, Long num) {
        return String.format("%0" + size + "d", num);
    }

    public static String leadingZero(int size, int num) {
        return String.format("%0" + size + "d", num);
    }

    public static String removeZero(String str) {
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        return str.replaceAll("^(0+)", "");
    }

    public static String addZero(String str, int length) {
        String zero = "00000000000000000000000000000000000000000000000000";
        if (str == null) {
            return null;
        }
        return zero.substring(0, length - str.length()) + str;
    }

    /**
     * 小时分钟加上间隔
     *
     * @param hm
     * @param add
     * @return
     */
    public static String hourMinuteAddMinute(String hm, Integer add) {
        Integer h = Integer.parseInt(hm.split(":")[0]);
        Integer m = Integer.parseInt(hm.split(":")[1]);
        m += add;
        h += m / 60;
        m = m % 60;
        h = h % 24;
        return (h < 10 ? "0" + h : "" + h) + ":" + (m < 10 ? "0" + m : "" + m);
    }

    private static ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<>();
    public static SimpleDateFormat getSimpleDateFormat(String fm) {
        if(fm==null){
            threadLocal.remove();
            return null;
        }
        SimpleDateFormat sdf;
        sdf = threadLocal.get();
        if (sdf == null) {
            sdf = new SimpleDateFormat(fm);
            threadLocal.set(sdf);
        }
        return sdf;
    }

    public static boolean checkSign(String sign, String content) {
        String getContent = "";
        try {
            getContent = URLDecoder.decode(content, "UTF-8");
            log.info("加密之前: {}", getContent);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        // 将content转换成JSON对象；
        String calSign = DigestUtils.md5Hex(getContent + "xgwzrf4pv25tu7y6begl");
        log.info("加密之后: {}", calSign);
        if(sign.equals(calSign)){
            return true;
        }
        return false;
    }

}
