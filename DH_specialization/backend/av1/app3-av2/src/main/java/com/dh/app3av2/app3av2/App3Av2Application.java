package com.dh.app3av2.app3av2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class App3Av2Application {

	public static void main(String[] args) {
		SpringApplication.run(App3Av2Application.class, args);
	}

}
