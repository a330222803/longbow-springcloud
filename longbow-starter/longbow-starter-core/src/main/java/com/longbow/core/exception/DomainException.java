package com.longbow.core.exception;

/**
 * 领域对象构建出现异常
 * Created by zhangbin on 2016/2/11.
 */
public class DomainException extends BizBaseException {

    public DomainException(String message) {
        super(message);
    }

    public DomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
