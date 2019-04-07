package com.longbow.security.core.core;

import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * Created by zhangbin on 2017/10/27.
 */
@Component("longbowAccessDecisionVoter")
public class LongbowAccessDecisionVoter implements AccessDecisionVoter<Object> {
    @Override
    public boolean supports(Class aClass) {
        return true;
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return attribute instanceof SecurityConfig;
    }

    @Override
    public int vote(Authentication authentication, Object o, Collection<ConfigAttribute> configAttributes) {
        int result = ACCESS_ABSTAIN;

        for (ConfigAttribute attribute : configAttributes) {
            if (this.supports(attribute)) {
                result = ACCESS_DENIED;
                //访问所请求资源所需要的权限
                String needPermission = attribute.getAttribute();
                System.out.println("needPermission is " + needPermission);
                //用户所拥有的权限authentication
                for (GrantedAuthority ga : authentication.getAuthorities()) {
                    if (needPermission.equals(ga.getAuthority())) {
                        return ACCESS_GRANTED;
                    }
                }
            }
        }

        return result;
    }
}
