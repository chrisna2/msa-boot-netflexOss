package com.tyn.bnk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.tyn.bnk.filter.GatewayFilter;

@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
@EnableHystrixDashboard
public class MsaSa03BnkcloudZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsaSa03BnkcloudZuulApplication.class, args);
	}
	@Bean
	public GatewayFilter filter() {
		return new GatewayFilter();
	}
}
