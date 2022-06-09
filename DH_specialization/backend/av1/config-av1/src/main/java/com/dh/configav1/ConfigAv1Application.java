package com.dh.configav1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigAv1Application {

	public static void main(String[] args) {
		SpringApplication.run(ConfigAv1Application.class, args);
	}

}
