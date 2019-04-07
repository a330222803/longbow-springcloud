package com.longbow.core.constants;

/**
 * 终端设备类型的枚举
 * Created by zhangbin on 2016/5/5.
 */
public enum OperTypeEnum implements ConstantEnum {

    WRITE("w", 1),
    UPDATE("u", 2),
    READ("r", 3);

    private final String text;

    private final Integer value;

    OperTypeEnum(String text, Integer value) {
        this.text = text;
        this.value = value;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public String getText() {
        return text;
    }
}
