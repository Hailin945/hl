package com.hl.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * zipkin项目启动类
 *
 * @author Hailin
 * @date 2019-10-14
 */
@SpringBootApplication
public class HlZipkinApplication {

    public static void main(String[] args) {
        SpringApplication.run(HlZipkinApplication.class, args);
    }
}
