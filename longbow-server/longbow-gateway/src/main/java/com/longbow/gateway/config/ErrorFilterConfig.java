package com.longbow.gateway.config;

import com.longbow.gateway.filter.error.ErrorFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zhangbin on 2018/8/13.
 */
@Configuration
public class ErrorFilterConfig {

    @Bean
    public ErrorFilter errorFilter(){
        return new ErrorFilter();
    }
}
