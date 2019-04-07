package com.longbow.core.exception;

/**
 * 出现重复业务实体时候的异常
 * Created by zhangbin on 2016/2/11.
 */
public class DuplicateEntityException extends PersistenceException {

    public DuplicateEntityException(String message) {
        super(message);
    }

    public DuplicateEntityException(String message, Throwable cause) {
        super(message, cause);
    }
}
