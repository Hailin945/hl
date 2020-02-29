package com.hl.activemq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Hailin
 * @date 2020/1/29
 */
@SpringBootApplication
@ComponentScans({
        @ComponentScan("com.hl.activemq.config")
})
@EnableScheduling
public class ActiveMqApplication {
    public static void main(String[] args) {
        SpringApplication.run(ActiveMqApplication.class, args);
    }
}
