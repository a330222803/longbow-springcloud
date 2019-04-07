package com.longbow.security.core.core;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.expression.WebSecurityExpressionRoot;

import java.util.Collection;

/**
 * Created by zhangbin on 2017/10/29.
 */
public class LongbowWebSecurityExpressionRoot extends WebSecurityExpressionRoot {
    public static SimpleGrantedAuthority ADMIN_AUTHORITY = new SimpleGrantedAuthority("ADMIN");

    public LongbowWebSecurityExpressionRoot(Authentication a, FilterInvocation fi) {
        super(a, fi);
    }

    public boolean isCustomAdmin() {
        Collection userAuthorities = this.authentication.getAuthorities();

        if (userAuthorities.contains(ADMIN_AUTHORITY)) {
            return true;
        } else {
            return false;
        }
    }

}
