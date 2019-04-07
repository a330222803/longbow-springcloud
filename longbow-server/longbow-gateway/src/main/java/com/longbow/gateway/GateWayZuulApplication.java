package com.longbow.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @description zuul启动类
 * @author zhangbin
 * @date
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class GateWayZuulApplication {

//	@Bean
//	public PatternServiceRouteMapper serviceRouteMapper() {
////		return new PatternServiceRouteMapper(
////				"(?<name>^.+)-(?<version>v.+$)",
////				"${version}/${name}");
//	}

	public static void main(String[] args) {
		SpringApplication.run(GateWayZuulApplication.class, args);
	}
}