package com.longbow.security.core.suppot.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.longbow.security.LongbowSecurity;
import com.longbow.security.core.core.LongbowSecurityMetadataSource;
import com.longbow.security.core.util.HttpUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.ConfigAttribute;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@Slf4j
public class DefaultLongbowSecurityImpl implements LongbowSecurity {
    @Value("${spring.application.name}")
    private String appName;

    @Value("${longbow.security.server}")
    private String secServer;

    @Autowired
    @Qualifier("easySpringSecurityMetadataSource")
    private LongbowSecurityMetadataSource securityMetadataSource;

    @Override
    public Map<String, Collection<ConfigAttribute>> fetchSecurityConfig() {
        log.debug("DefaultLongbowSecurityImpl.fetchSecurityConfig is called");
        String result = HttpUtil.sendGet(secServer + "/privilege/pub/system?appName="+appName);
        HashMap<String, Collection<ConfigAttribute>> privileges = JSON.parseObject(result,new TypeReference<HashMap<String, Collection<ConfigAttribute>>>(){});
        return privileges;
    }

    @Override
    public boolean refreshSecurity() {
        log.debug("DefaultLongbowSecurityImpl.refreshSecurity is called");
        try {
            securityMetadataSource.flashMem();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
