package com.digital.house.aula02_keycloak.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {

		http
				.authorizeExchange()
				.anyExchange()
				.authenticated()
				.and()
				.oauth2Login();

		return http.build();
	}

}
