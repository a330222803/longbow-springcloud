package com.longbow.core.jwt;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * JWT的主体部分，以JSON串保存在JWT中，可以直接解析JWT获得
 * Created by zhangbin on 2019/1/17.
 */
@Slf4j
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class JWTSubject implements Serializable, Cloneable {
    private long userId;//登录用户唯一标识
    private Set<String> roleSet;//用户角色清单，用于SpringSecurity判断权限的依据

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof JWTSubject) {
            JWTSubject jwtSubject = (JWTSubject) obj;
            if (Objects.equals(jwtSubject.getUserId(), this.getUserId())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        JWTSubject jwtSubject = new JWTSubject();
        jwtSubject.setUserId(this.getUserId());
        Set<String> roleSet = new HashSet<>();
        roleSet.addAll(this.getRoleSet());
        jwtSubject.setRoleSet(roleSet);
        return jwtSubject;
    }

}
