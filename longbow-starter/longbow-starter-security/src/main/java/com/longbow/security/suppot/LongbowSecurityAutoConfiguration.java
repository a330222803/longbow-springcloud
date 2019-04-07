package com.longbow.security.suppot;

import com.longbow.security.LongbowSecurity;
import com.longbow.security.core.suppot.web.DefaultLongbowSecurityImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.shanlin.bi.security.core"})
public class LongbowSecurityAutoConfiguration {
    @Bean
    public LongbowSecurity easySpringSecurity() {
        return new DefaultLongbowSecurityImpl();
    }
}
