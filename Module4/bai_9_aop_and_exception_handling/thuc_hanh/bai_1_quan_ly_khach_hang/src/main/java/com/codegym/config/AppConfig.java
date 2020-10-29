package com.codegym.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {

    @Bean
    public LogCustomer createLogStudent() {
        return new LogCustomer();
    }
}
