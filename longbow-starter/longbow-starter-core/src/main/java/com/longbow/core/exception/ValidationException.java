package com.longbow.core.exception;

/**
 * 校验出现异常
 * Created by zhangbin on 2016/2/11.
 */
public class ValidationException extends DomainException {

    public ValidationException(String message) {
        super(message);
    }

    public ValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
