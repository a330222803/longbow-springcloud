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
public class CertifyUserRequest implements Serializable {
    private Long uid;
    private String IDNumber;
    private String IDType;
}
