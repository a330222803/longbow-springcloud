package com.longbow.api.customer.domain;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.longbow.core.domain.BaseInfo;
import lombok.*;

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
public class StaffInfo extends BaseInfo {
//    TODO
    private String sysGroup;//蒋涛用的可能不是这个地方返回的 SELECT t.sys_group FROM t_crm_employee_group t
    private String phoneExt;//select ext from ccs_genesys_ip_ext where ip = #{ipAddr} limit 1
}

