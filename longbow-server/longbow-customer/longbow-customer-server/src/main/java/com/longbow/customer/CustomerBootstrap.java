package com.longbow.customer;

import com.longbow.core.util.ContextUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 客户服务启动类
 * Created by zhangbin on 2018/7/26.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients({"com.longbow.api.user.service"})
public class CustomerBootstrap {

    /**
     * 服务启动
     *
     * @param args 启动参数
     */
    public static void main(String[] args) {
        ContextUtil.current = SpringApplication.run(CustomerBootstrap.class, args);
    }
}
