package com.citic.discover;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscoverApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiscoverApplication.class, args);
        System.out.println("注册发现服务启动成功");
    }

}
