package com.longbow.core.exception;

/**
 * 持久化出现异常
 * Created by zhangbin on 2016/2/11.
 */
public class PersistenceException extends BizBaseException {

    public PersistenceException(String message) {
        super(message);
    }

    public PersistenceException(String message, Throwable cause) {
        super(message, cause);
    }
}
