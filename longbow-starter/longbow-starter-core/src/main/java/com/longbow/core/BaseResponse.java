package com.longbow.core;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * 界面的返回请求
 * Created by zhangbin on 2018/7/26.
 */
@Getter
@Setter
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse<T> implements Serializable {
    private Integer code;
    private String msg;
    private T data;

    public boolean isSuccess() {
        return (null != code && code == 0);
    }
}
