package com.longbow.api.user.dto;

import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * Created by zhangbin on 2019/3/19.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GetUserInfoResponse implements Serializable {
    private Long uid;
    private String nickname;
    private String username;
    private String email;
    private String mobile;
    private Date lastPasswordResetTime;
    private Date createTime;
    private Date updateTime;
    private Set<String> roles;
}
