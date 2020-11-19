package com.exercise.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableWebFluxSecurity
@Configuration
public class WebSecurityConfig {

    @Bean
    public SecurityWebFilterChain webFluxFilterChain(ServerHttpSecurity http) {
        http
                .csrf().disable()
                .authorizeExchange()
                .pathMatchers("/**").permitAll()
//               //option 请求默认放行
//                .pathMatchers(HttpMethod.OPTIONS).permitAll()
                .and()
                .formLogin()
        ;

        return http.build();
    }

}