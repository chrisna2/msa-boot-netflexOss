package com.tyn.bnk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

//Eureka Registry Server임을 선언 : 해당 서버의 주소정보로 각각의 MSA정보가 포트별로 정리되어 관리된다.
@EnableEurekaServer
@SpringBootApplication
public class MsaSa01Application {

	public static void main(String[] args) {
		SpringApplication.run(MsaSa01Application.class, args);
	}

}
