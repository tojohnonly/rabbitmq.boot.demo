package com.ensk.demo.rabbitmq.controller;

import java.util.Date;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleProducerController {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @RequestMapping("/simple/send")
    public String send() {
        String content = "Simple Message, Date: " + new Date();
        amqpTemplate.convertAndSend("test_queue_simple", content);
        return content;
    }
}