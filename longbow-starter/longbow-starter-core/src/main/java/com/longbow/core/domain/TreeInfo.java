package com.longbow.core.domain;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 树状存储对象
 * Created by zhangbin on 2016/4/15.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TreeInfo<T> extends BaseInfo {

    /**
     * 父对象
     */
    protected T parent;

    /**
     * 是否可选中
     */
    protected boolean clickable = true;

    /**
     * 存储所有的子对象
     */
    protected List<T> children = new ArrayList<>();

    /**
     * 是否叶子节点
     */
    protected boolean leaf = true;

    protected String type = "leaf";

}
