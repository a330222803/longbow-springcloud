package com.longbow.core.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * 对象比较的结果信息
 * Created by zhangbin on 2016/8/5.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiffInfo implements Serializable {

    private String field;

    private Object begVal;

    private Object endVal;

    public String toString(){
        return field+":"+begVal+"--->"+endVal;
    }
}
