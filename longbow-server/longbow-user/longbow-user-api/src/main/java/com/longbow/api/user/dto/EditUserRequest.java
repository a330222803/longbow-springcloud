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
public class EditUserRequest implements Serializable {
    private String username;
    private String email;
    private String mobile;
}
