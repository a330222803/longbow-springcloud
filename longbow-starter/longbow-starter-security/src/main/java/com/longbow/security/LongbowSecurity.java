package com.longbow.security;

import org.springframework.security.access.ConfigAttribute;

import java.util.Collection;
import java.util.Map;

public interface LongbowSecurity {
    /**
     * 获取统一赋权中心权限配置数据
     * @return
     */
    Map<String, Collection<ConfigAttribute>> fetchSecurityConfig();

    /**
     * 刷新权限配置数据
     * @return
     */
    boolean refreshSecurity();
}
