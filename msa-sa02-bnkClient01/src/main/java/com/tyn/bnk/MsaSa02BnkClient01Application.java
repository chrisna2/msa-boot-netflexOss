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

	public static void main(String[] args) {
		SpringApplication.run(MsaSa02BnkClient01Application.class, args);
	}

}
