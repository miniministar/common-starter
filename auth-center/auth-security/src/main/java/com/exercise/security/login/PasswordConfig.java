package com.exercise.security.login;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 装配密码匹配器
 */
@Configuration
public class PasswordConfig {
    @Bean
    public PasswordEncoder passwordEncoder()	{
        return new BCryptPasswordEncoder();
    }
}
