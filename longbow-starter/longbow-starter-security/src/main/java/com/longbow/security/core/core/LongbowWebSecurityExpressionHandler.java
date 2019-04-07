package com.longbow.security.core.core;

import org.springframework.security.access.expression.SecurityExpressionOperations;
import org.springframework.security.access.expression.SecurityExpressionRoot;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;

/**
 * Created by zhangbin on 2017/10/29.
 */
//@Component("longbowExpressionHandler")
public class LongbowWebSecurityExpressionHandler extends DefaultWebSecurityExpressionHandler {
    @Override
    protected SecurityExpressionOperations createSecurityExpressionRoot(Authentication authentication, FilterInvocation fi) {
        SecurityExpressionRoot root = new LongbowWebSecurityExpressionRoot(authentication, fi);
        root.setTrustResolver(new AuthenticationTrustResolverImpl());
        return root;
    }
}
