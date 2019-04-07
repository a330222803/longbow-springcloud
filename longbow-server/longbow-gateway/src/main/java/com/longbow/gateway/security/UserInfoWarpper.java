//package com.longbow.gateway.security;
//
//import com.alibaba.fastjson.JSON;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import com.longbow.crm.api.user.domain.SysRoleInfo;
//import com.longbow.crm.api.user.domain.UserInfo;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.*;
//
///**
// * Created by zhangbin on 2018/9/20.
// */
//@Slf4j
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@JsonIgnoreProperties(ignoreUnknown = true)
//public class UserInfoWarpper implements UserDetails {
//    private UserInfo userInfo;
//
//    @Override
//    @JsonIgnore
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        Collection<GrantedAuthority> auths = new ArrayList<>();
//        List<SysRoleInfo> roles = userInfo.getRoles();
//        Set<String> set = new HashSet<>();
//        if (roles == null) {
//            return auths;
//        }
//        for (SysRoleInfo role : roles) {
//            set.add(role.getRolName());
//        }
//        for (Iterator<String> it = set.iterator(); it.hasNext(); ) {
//            String name = it.next();
//            auths.add(new SimpleGrantedAuthority(name));
//        }
//        log.info("用户的角色清单：{}", JSON.toJSONString(auths));
//        return auths;
//    }
//
//    @Override
//    public String getPassword() {
//        return userInfo.getPassword();
//    }
//
//    @Override
//    public String getUsername() {
//        return userInfo.getUsername();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//}
