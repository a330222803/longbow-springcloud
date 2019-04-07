package com.longbow.core.util;

import com.longbow.core.exception.DomainException;

/**
 *系统的回调函数
 * Created by zhangbin on 2016/6/22.
 */
@FunctionalInterface
public interface BaseCall<E, R> {

    void call(E e, R r) throws DomainException;
}
