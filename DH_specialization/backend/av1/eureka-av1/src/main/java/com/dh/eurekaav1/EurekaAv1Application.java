package com.dh.eurekaav1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaAv1Application {

	public static void main(String[] args) {
		SpringApplication.run(EurekaAv1Application.class, args);
	}

}
