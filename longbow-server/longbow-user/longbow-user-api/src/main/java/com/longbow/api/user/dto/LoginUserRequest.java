package com.longbow.api.user.dto;

import lombok.*;

import java.io.Serializable;

/**
 * Created by zhangbin on 2019/3/19.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LoginUserRequest implements Serializable {
    private String accountNumber; // 登录账号：用户名/邮箱/手机号码
    private String password;
}
