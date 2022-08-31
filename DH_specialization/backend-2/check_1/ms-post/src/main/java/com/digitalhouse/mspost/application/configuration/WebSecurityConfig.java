package com.digitalhouse.mspost.application.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@RequiredArgsConstructor
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtAuthConverter jwtAuthConverter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.POST, "/post/save", ADMIN)
                .antMatchers(HttpMehotd.GET)
                .antMatchers(HttpMethod.GET, "/api/movies", "/api/movies/**", "/actuator/**").permitAll()
                .antMatchers("/api/movies/**/comments").hasAnyRole(MOVIES_MANAGER, USER, JOURNALIST)
                .antMatchers("/api/movies", "/api/movies/**").hasRole(MOVIES_MANAGER)
                .antMatchers("/api/userextras/me").hasAnyRole(MOVIES_MANAGER, USER, JOURNALIST)
                .antMatchers(HttpMethod.GET, "/actuator/**").permitAll()
                .antMatchers("/swagger-ui.html", "/swagger-ui/**", "/v3/api-docs", "/v3/api-docs/**").permitAll()
                .anyRequest().authenticated();
        http.oauth2ResourceServer()
                .jwt()
                .jwtAuthenticationConverter(jwtAuthConverter);
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.cors().and().csrf().disable();
    }

    public static final String EDITOR = "EDITOR";
    public static final String USER = "USER";

    public static final String ADMIN = "ADMIN";

}