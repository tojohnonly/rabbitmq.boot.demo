package com.ensk.demo.rabbitmq.controller;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FanoutProducerController {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @RequestMapping("/fanout/send")
    public String send() {
        String content = "Fanout Message, Date: " + new Date();
        amqpTemplate.convertAndSend("test_fanout_exchange", "", content);
        return content;
    }
}