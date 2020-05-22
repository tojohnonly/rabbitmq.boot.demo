package com.ensk.demo.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "test_queue_simple")
public class SimpleConsumer {

    @RabbitHandler
    public void receiver(String msg) {
        System.out.println("Simple Consumer: " + msg);
    }
}