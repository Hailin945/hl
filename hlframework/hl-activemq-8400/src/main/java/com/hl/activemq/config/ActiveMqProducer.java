package com.hl.activemq.config;

import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jms.Queue;

/**
 * @author Hailin
 * @date 2020/1/29
 */
@Component
public class ActiveMqProducer {

    @Resource
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Resource
    private Queue queue;

    @Scheduled(fixedDelay = 5000L)
    public void send() {
        String s = System.currentTimeMillis() + "";
        jmsMessagingTemplate.convertAndSend(queue, System.currentTimeMillis());
        System.out.println(String.format("点对点通讯，msg:%s", s));
    }
}
