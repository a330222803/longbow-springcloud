/*
 * Copyright (c) 2016 Breezee.org. All Rights Reserved.
 */

package com.longbow.core.util;

import javafx.util.Callback;
import org.springframework.beans.BeanUtils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * 对bean的一些通用操作
 * Created by zhangbin on 2016/2/7.
 */
public class BeanUtil {

    /**
     * 使用Spring的bean 2 bean
     *
     * @param source
     * @param target
     * @param ignoreProperties
     * @param <P>
     * @param <R>
     */
    public static <P, R> R beanCopy(P source, R target, String... ignoreProperties) {
        return beanCopy(source, target, null, ignoreProperties);
    }

    /**
     * 存在回调的bean 2 bean
     *
     * @param source
     * @param target
     * @param callback
     * @param ignoreProperties
     * @param <P>
     * @param <R>
     */
    public static <P, R> R beanCopy(P source, R target,
                                    Callback<P, R> callback, String... ignoreProperties) {
        BeanUtils.copyProperties(source, target, ignoreProperties);
        if (callback != null) {
            target = callback.call(source);
        }
        return target;
    }

    /**
     * 对象转Map
     *
     * @param obj 对象实例
     * @return map
     * @throws Exception 异常
     */
    public static Map<String, Object> objectToMap(Object obj) throws Exception {
        if (obj == null)
            return null;
        Map<String, Object> map = new HashMap<>();
        BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor property : propertyDescriptors) {
            String key = property.getName();
            if (key.compareToIgnoreCase("class") == 0) {
                continue;
            }
            Method getter = property.getReadMethod();
            Object value = getter != null ? getter.invoke(obj) : null;
            if (value != null)
                map.put(key, value);
        }
        return map;
    }

    /**
     * Map 转成对象
     *
     * @param map
     * @param obj
     * @return
     * @throws Exception
     */
    public static Object mapToObject(Map<String, Object> map, Object obj) throws Exception {
        if (map == null) {
            throw new RuntimeException("source is null");
        }
        BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor property : propertyDescriptors) {
            Method setter = property.getWriteMethod();
            if (setter != null) {
                System.out.println(property.getName()+"_"+obj.getClass().getName());
                System.out.println(map.get(property.getName()));
                if(map.get(property.getName())!=null){
                    System.out.println(map.get(property.getName()).getClass().getName());
                }
                setter.invoke(obj, map.get(property.getName()));
            }
        }
        return obj;
    }
}
