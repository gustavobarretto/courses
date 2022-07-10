package com.example.movieservice;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@SpringBootApplication
@EnableRabbit
@EnableFeignClients
public class MovieServiceApplication {

	public static void main (String[] args) {
		SpringApplication.run(MovieServiceApplication.class, args);
	}

}
