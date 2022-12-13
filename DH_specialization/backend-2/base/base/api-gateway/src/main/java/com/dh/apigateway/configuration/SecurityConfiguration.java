package com.dh.apigateway.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;


@Configuration
public class SecurityConfiguration {

  @Bean
  public SecurityWebFilterChain springSecurityFilterChain (ServerHttpSecurity http) {

    http
        .authorizeExchange()
        .anyExchange()
        .authenticated()
        .and()
        .oauth2Login(); // to redirect to oauth2 login page.

    return http.build();
  }
}
