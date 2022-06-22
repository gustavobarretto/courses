package com.dh.configav1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableConfigServer
public class ConfigAv1Application {

	public static void main(String[] args) {
		SpringApplication.run(ConfigAv1Application.class, args);
	}

}
