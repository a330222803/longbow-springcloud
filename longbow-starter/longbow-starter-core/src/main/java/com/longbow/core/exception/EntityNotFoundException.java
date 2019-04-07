package com.longbow.core.exception;

/**
 * 实体未找到的异常
 * Created by zhangbin on 2016/2/11.
 */
public class EntityNotFoundException extends PersistenceException {

    public EntityNotFoundException(String message) {
        super(message + ":Not Found");
    }

    public EntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
