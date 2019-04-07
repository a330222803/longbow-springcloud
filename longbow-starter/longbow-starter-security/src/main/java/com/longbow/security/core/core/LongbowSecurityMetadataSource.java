package com.longbow.security.core.core;

import com.longbow.security.LongbowSecurity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by zhangbin on 2017/10/29.
 */
@Slf4j
@Component("longbowSecurityMetadataSource")
public class LongbowSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
    private FilterInvocationSecurityMetadataSource defaultMetadataSource;
    private Map<String, Collection<ConfigAttribute>> extendResourceMap = null;

    private RequestMatcher urlMatcher;

    @Autowired
    private LongbowSecurity easySpringSecurity;

    public LongbowSecurityMetadataSource() {
    }

    public FilterInvocationSecurityMetadataSource getDefaultMetadataSource() {
        return defaultMetadataSource;
    }

    public void setDefaultMetadataSource(FilterInvocationSecurityMetadataSource defaultMetadataSource) {
        this.defaultMetadataSource = defaultMetadataSource;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return defaultMetadataSource.getAllConfigAttributes();
    }

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        Collection<ConfigAttribute> attributes = new ArrayList<>();

        Collection<ConfigAttribute> defaultAttributes = defaultMetadataSource.getAttributes(object);

        if(defaultAttributes != null){
            attributes.addAll(defaultAttributes);
        }

        FilterInvocation filterInvocation = (FilterInvocation) object;
        Iterator<String> ite = extendResourceMap.keySet().iterator();
        //取到请求的URL后与上面取出来的资源做比较
        while (ite.hasNext()) {
            String resURL = ite.next();
            urlMatcher = new AntPathRequestMatcher(resURL);
            if (urlMatcher.matches(filterInvocation.getHttpRequest())) {
                attributes.addAll(extendResourceMap.get(resURL));
            }
        }
        return attributes;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return defaultMetadataSource.supports(aClass);
    }

    /**
     * 自定义方法，这个类放入到Spring容器后，
     * 指定init为初始化方法，从数据库中读取资源
     */
//    @PostConstruct
    public void init() {
        loadResourceDefine();
    }

    /**
     * 程序启动的时候就加载所有资源信息.
     */
    private void loadResourceDefine() {
        // 在Web服务器启动时，提取平台权限管理系统中的所有权限。
        Map<String, Collection<ConfigAttribute>> query = easySpringSecurity.fetchSecurityConfig();

        /**
         * 应当是资源为key， 权限为value。 资源通常为url， 权限就是那些以ROLE_为前缀的角色。
         * 一个资源可以由多个权限来访问。
         */
        extendResourceMap = query;
    }

    /**
     * 刷新缓存
     *
     * @param
     * @throws Exception
     */
    public void flashMem() throws Exception {
        this.init();
    }
}
