package com.longbow.core.exception;

/**
 * 事件驱动模型出现的异常
 * <p>
 * Created by zhangbin on 2016/4/28.
 */
public class EventException extends DomainException {

    private String message;

    public EventException(String message) {
        super(message);
        this.message = message;
    }

    public void addMessage(String message) {
        if (this.message == null) {
            this.message = message;
        } else {
            this.message += "," + message;
        }
    }

    public String getAppendMessage() {
        return this.message;
    }
}
