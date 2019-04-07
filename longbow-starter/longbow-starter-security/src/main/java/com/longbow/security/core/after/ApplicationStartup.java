package com.longbow.security.core.after;

import com.longbow.security.core.config.security.WebSecurityConfig;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by zhangbin on 2017/10/16.
 */
@Component
public class ApplicationStartup implements ApplicationListener<ContextRefreshedEvent> {
    private final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private WebSecurityConfig webSecurityConfig;

    public void onApplicationEvent(ContextRefreshedEvent event) {
        try {
            webSecurityConfig.changeSome();
        } catch (Exception e) {
            logger.info(">>>>更换自定义权限表决器出错.<<<<");
            e.printStackTrace();
        }
        logger.info(">>>>系统启动完毕.<<<<");
    }
}
