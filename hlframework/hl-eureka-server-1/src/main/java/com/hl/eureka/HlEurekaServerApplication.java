package com.hl.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * MBC项目的子项目EUREKA-SERVER项目的启动类
 *
 * @author Hailin
 * @date 2019-04-27
 */
@EnableEurekaServer
@SpringBootApplication
public class HlEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(HlEurekaServerApplication.class, args);
    }
}
