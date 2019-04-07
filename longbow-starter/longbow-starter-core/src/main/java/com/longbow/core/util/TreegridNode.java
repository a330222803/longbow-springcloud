package com.longbow.core.util;

import java.util.ArrayList;
import java.util.List;

public class TreegridNode<T> {

    private T data;

    private List<TreegridNode<T>> children;

    public TreegridNode(T data) {
        this.data = data;
        this.children = new ArrayList<>();
    }

    public List<TreegridNode<T>> getChildren() {
        return children;
    }

    public void setChildren(List<TreegridNode<T>> children) {
        this.children = children;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
