package com.tyn.bnk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaClient//유레카 클라이언트 임을 선언
@EnableAutoConfiguration
@RestController
@EnableCircuitBreaker
@SpringBootApplication
@CrossOrigin(origins="*")
public class MsaSa02BnkClient01Application {
//@SpringBootApplication : 이 클래스가 프로젝트의 부트 클래스임을 의미함
	public static void main(String[] args) {
		SpringApplication.run(MsaSa02BnkClient01Application.class, args);//스프링 부트를 시작하기 위해 호출된다.
	}

}
