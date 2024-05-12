package com.carecarestinga.msautentica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class MsAutenticaApplication {

	public static void main(String[] args) {
		SpringApplication.run(com.carecarestinga.msautentica.MsAutenticaApplication.class, args);
	}

}
