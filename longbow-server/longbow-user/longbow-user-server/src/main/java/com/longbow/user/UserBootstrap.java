package com.longbow.user;

import com.longbow.core.util.ContextUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 客户服务启动类
 * Created by zhangbin on 2018/7/26.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class UserBootstrap {

    /**
     * 服务启动
     *
     * @param args 启动参数
     */
    public static void main(String[] args) {
        ContextUtil.current = SpringApplication.run(UserBootstrap.class, args);
    }
}
