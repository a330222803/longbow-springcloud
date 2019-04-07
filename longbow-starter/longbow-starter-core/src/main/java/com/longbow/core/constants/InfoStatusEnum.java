package com.longbow.core.constants;

/**
 * 实体状态的枚举值设定
 * 在做Jackson数据绑定的时候，请记住直接传递：DISABLE,ENABLE即可
 * Created by zhangbin on 2016/4/28.
 */
public enum InfoStatusEnum implements ConstantEnum {

    DISABLE("禁用", 0),
    ENABLE("启用", 1),
    UNKNOWN("位置", -1),
    SUCCESS("成功", 100),
    ERROR("错误", -100);

    private final String text;

    private final Integer value;

    InfoStatusEnum(String text, Integer value) {
        this.text = text;
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }

    public String getText() {
        return this.text;
    }

    public String toString() {
        return this.getText();
    }

}
