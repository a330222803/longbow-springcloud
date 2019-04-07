package com.longbow.api.customer.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.longbow.core.domain.BaseInfo;
import lombok.*;

import java.util.Date;

/**
 * 进线客户对象
 * Created by zhangbin on 2018/7/26.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CustomerInfo extends BaseInfo {

    protected String scName, scSex, scPhone, scAddress, scProvince;
    protected Date dtCommitTime;
    protected Integer sportId = 0;
    protected String sportName;
    protected Integer refId = 0;
    protected String scReffer;
    protected String ip, username, assign;
    protected Integer dtFetchTime, dtHandelTime;
    protected Integer refId2 = 0;
    protected Integer refId3 = 0;
    protected Integer refId4 = 0;
    protected Integer rs = 0;
    protected Integer scId = 0;
    protected String scPlatform, extNo;

    @JsonProperty("ext_pro_wechatNickname")
    protected String wechatNickname;
    @JsonProperty("ext_pro_wechatHeadImg")
    protected String wechatHeadImg;
    @JsonProperty("ext_pro_wechatUnionId")
    protected String wechatUnionId;

}

