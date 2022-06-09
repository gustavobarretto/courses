package com.dh.app1av1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class App1Av1Application {

	public static void main(String[] args) {
		SpringApplication.run(App1Av1Application.class, args);
	}

}
