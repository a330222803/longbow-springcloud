package com.longbow.api.user.dto;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by zhangbin on 2019/3/19.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RegisterUserRequest implements Serializable {
    @NotNull(message="用户名不能为空")
    private String username;
    @NotEmpty(message = "密码不能为空")
    private String password;
    @Email(message="邮箱格式错误")
    private String email;
    private String mobile;
}
