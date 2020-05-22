package com.ensk.demo.rabbitmq.controller;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkProducerController {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @RequestMapping("/work/send")
    public String send() {
        for (int i = 0; i < 10; i++) {
            String content = String.format("Work Message, No.%d, Date: %s", i, new Date());
            amqpTemplate.convertAndSend("test_queue_work", content);
        }
        return String.valueOf(System.nanoTime());
    }
}