package com.longbow.core.exception;

/**
 * 禁止访问的异常
 * Created by zhangbin on 2016/2/11.
 */
public class AccessForbiddenException extends BizBaseException {

    public AccessForbiddenException(String message) {
        super(message);
    }

    public AccessForbiddenException(String message, Throwable cause) {
        super(message, cause);
    }
}
