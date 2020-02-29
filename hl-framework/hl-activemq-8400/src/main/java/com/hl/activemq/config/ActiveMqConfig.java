package com.hl.activemq.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

/**
 * @author Hailin
 * @date 2020/1/29
 */
@Component
public class ActiveMqConfig {

    @Value("spring.activemq.my_queue")
    private String myQueue;

    @Bean
    public Queue myQueue() {
        return new ActiveMQQueue(myQueue);
    }
}
