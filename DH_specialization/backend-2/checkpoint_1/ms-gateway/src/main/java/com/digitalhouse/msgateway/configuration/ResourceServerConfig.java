package com.digitalhouse.msgateway.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class ResourceServerConfig {

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity httpSecurity) {
        httpSecurity
                .authorizeExchange()
                .anyExchange()
                .authenticated()
                .and()
                .oauth2Login();

        return httpSecurity.build();
    }
}
