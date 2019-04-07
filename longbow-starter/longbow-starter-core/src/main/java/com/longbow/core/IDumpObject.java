package com.longbow.core;

/**
 * 支持输出调试的接口
 * Created by zhangbin on 2016/4/21.
 */
public interface IDumpObject {

    /**
     * 在控制台输出调试信息
     */
    void dump();

    /**
     * 比较对象之间的差异
     * @param o 对比对象
     * @return 比较后的对象
     */
    Object diff(Object o);
}
