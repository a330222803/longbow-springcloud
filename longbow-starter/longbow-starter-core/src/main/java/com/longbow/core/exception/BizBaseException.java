package com.longbow.core.exception;

/**
 * 系统基础异常类
 * //--实际开发中，我们没有对Exception进行了分类。这个需要改善
 * 供系统其他异常集成
 * Created by zhangbin on 2017/7/26.
 */
public class BizBaseException extends RuntimeException {

    protected Integer code;

    public BizBaseException(String message) {
        super(message);
    }

    public BizBaseException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public BizBaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
