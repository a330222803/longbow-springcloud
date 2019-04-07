package com.longbow.uid;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by zhangbin on 2019/3/9.
 */
@Configuration
//@PropertySource(value = "classpath:uid/mysql.properties", encoding = "UTF-8")
@PropertySource(value = "classpath:uid/uid-mysql.properties", encoding = "UTF-8")
@ImportResource(locations = { "classpath:uid/cached-uid-spring.xml" })
@ComponentScan(basePackages = {"com.baidu.fsg.uid","com.longbow.uid"})
public class UidConfig {
}
