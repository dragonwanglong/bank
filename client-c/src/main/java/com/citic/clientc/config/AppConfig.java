package com.citic.clientc.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan("com.citic.clientc")
public class AppConfig {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        RestTemplate template = new RestTemplate();
        return template;
    }
}
