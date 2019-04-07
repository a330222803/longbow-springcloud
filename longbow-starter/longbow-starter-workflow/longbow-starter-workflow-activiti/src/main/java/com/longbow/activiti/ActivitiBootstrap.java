package com.longbow.activiti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 客户服务启动类
 * Created by zhangbin on 2018/7/26.
 */
@SpringBootApplication
public class ActivitiBootstrap {

    /**
     * 服务启动
     *
     * @param args 启动参数
     */
    public static void main(String[] args) {
        SpringApplication.run(ActivitiBootstrap.class, args);
    }
}
