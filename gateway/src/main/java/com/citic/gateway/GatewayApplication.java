package com.citic.gateway;

import com.citic.filter.PreFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class GatewayApplication {

    @Bean
    public PreFilter perFilter(){
        return new PreFilter();
    }
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
        System.out.println("gatewany run...");
    }

}
