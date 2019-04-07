package com.longbow.core;

import com.alibaba.fastjson.JSON;
import com.longbow.core.annotation.RequireSign;
import com.longbow.core.annotation.UnCheckSign;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.PropertyUtilsBean;
import org.apache.commons.codec.digest.DigestUtils;

import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeMap;

/**
 * Created by zhangbin on 2016/12/24.
 */
@Getter
@Setter
@Slf4j
public abstract class GenericRequest implements Serializable {
    private static final long serialVersionUID = 269749618934807240L;
    public String appId;
    public String version;
    @UnCheckSign
    private String sign;
    @UnCheckSign
    private String token;
    @UnCheckSign
    private String secret;

    public static boolean checkSign(GenericRequest request) {
        TreeMap<String, Object> params = beanToMap(request);

        Iterator<String> iter = params.keySet().iterator();
        StringBuilder sb = new StringBuilder();
        sb.append(request.getSecret());
        while (iter.hasNext()) {
            String key = iter.next();
            Object value = params.get(key);
            if (value!=null&&!"null".equals(String.valueOf(value))){
                sb.append(key.toLowerCase()).append(params.get(key).toString().replaceAll(" ",""));
            }
        }
        sb.append(request.getSecret());
        log.info("sbmd5Str:" + sb);
        String md5str = DigestUtils.md5Hex(sb.toString());
        log.info(md5str);
        if (md5str.equals(request.getSign())) {
            return true;
        }

        return false;
    }

    public static TreeMap beanToMap(Object obj) {
        TreeMap<String, Object> params = new TreeMap<>();
        if (obj == null) {
            return params;
        }
        try {
            PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean();
            Field[] fields = getAllField(obj.getClass());//obj.getClass().getFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(UnCheckSign.class)) {
                    continue;
                }
                try {
                    params.put(field.getName(), propertyUtilsBean.getNestedProperty(obj, field.getName()) + "");
                } catch (NoSuchMethodException e) {
                }
            }
        } catch (Exception e) {
        }
        log.debug(JSON.toJSONString(params));
        return params;
    }

    public static boolean validate(Object obj) {
        try {
            Field[] fields = obj.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(RequireSign.class)) {
                    RequireSign anno = field.getAnnotation(RequireSign.class);
                    if (anno.require()) {
                        PropertyDescriptor pd = new PropertyDescriptor(field.getName(), obj.getClass());
                        Method getMethod = pd.getReadMethod();//获得get方法
                        Object value = getMethod.invoke(obj);//执行get方法返回一个Object
                        if (value == null) {
                            return false;
                        }
                    }
                }
            }
        } catch (Exception e) {
        }
        return true;
    }

    /**
     * 获取类clazz的所有Field，包括其父类的Field，如果重名，以子类Field为准。
     *
     * @param clazz
     * @return Field数组
     */
    public static Field[] getAllField(Class<?> clazz) {
        ArrayList<Field> fieldList = new ArrayList<Field>();
        Field[] dFields = clazz.getDeclaredFields();
        if (null != dFields && dFields.length > 0) {
            fieldList.addAll(Arrays.asList(dFields));
        }

        Class<?> superClass = clazz.getSuperclass();
        if (superClass != Object.class) {
            Field[] superFields = getAllField(superClass);
            if (null != superFields && superFields.length > 0) {
                for (Field field : superFields) {
                    if (!isContain(fieldList, field)) {
                        fieldList.add(field);
                    }
                }
            }
        }
        Field[] result = new Field[fieldList.size()];
        fieldList.toArray(result);
        return result;
    }

    /**
     * 检测Field List中是否已经包含了目标field
     *
     * @param fieldList
     * @param field     带检测field
     * @return
     */
    public static boolean isContain(ArrayList<Field> fieldList, Field field) {
        for (Field temp : fieldList) {
            if (temp.getName().equals(field.getName())) {
                return true;
            }
        }
        return false;
    }

}
