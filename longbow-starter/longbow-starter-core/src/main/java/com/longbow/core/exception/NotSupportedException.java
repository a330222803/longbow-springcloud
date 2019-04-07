package com.longbow.core.exception;

/**
 * 不支持的异常信息
 * Created by zhangbin on 2016/6/3.
 */
public class NotSupportedException extends BizBaseException {

    public NotSupportedException(String message) {
        super(message);
    }

    public NotSupportedException(String message, Throwable cause) {
        super(message, cause);
    }
}
