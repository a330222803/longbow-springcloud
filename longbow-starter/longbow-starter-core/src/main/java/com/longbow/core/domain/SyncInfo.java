package com.longbow.core.domain;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * 需要与外部系统同步的对象
 * Created by zhangbin on 2016/6/9.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SyncInfo implements Serializable {

    /**
     * 同步时间，假设存在同步的话
     */
    protected Date syncTime;

    /**
     * 同步结果
     */
    protected Boolean syncResult;

    /**
     * 结果信息
     */
    protected String syncMessage;

    /**
     * 第三方系统标识
     */
    protected String dn;
}
