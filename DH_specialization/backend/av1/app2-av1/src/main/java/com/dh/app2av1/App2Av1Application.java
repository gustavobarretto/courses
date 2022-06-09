package com.dh.app2av1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class App2Av1Application {

	public static void main(String[] args) {
		SpringApplication.run(App2Av1Application.class, args);
	}

}
