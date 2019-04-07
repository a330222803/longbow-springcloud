package com.longbow.core;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * 领域对象的基本信息
 * 将被系统内的所有领域对象所继承
 * Created by zhangbin on 2016/2/6.
 */
@Getter
@Setter
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
public class BaseRequest<T> implements Serializable {

    /**
     * 数字签名，验证请求数据是否有效
     */
    protected String sign;

    /**
     * 请求携带的数据
     */
    @JsonProperty("content")
    protected T data;

    public boolean checkSign() {
        String getContent = "";
        try {
            getContent = URLDecoder.decode(data.toString(), "UTF-8");
            log.info("content:"+getContent);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        // 将content转换成JSON对象；
        String calSign = DigestUtils.md5Hex(getContent + "xgwzrf4pv25tu7y6begl");
        if(sign.equals(calSign)){
            return true;
        }
        return false;
    }

}
