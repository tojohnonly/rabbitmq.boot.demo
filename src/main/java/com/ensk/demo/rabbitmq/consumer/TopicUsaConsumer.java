package com.ensk.demo.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "test_queue_topic_usa")
public class TopicUsaConsumer {

    @RabbitHandler
    public void receiver(String msg) {
        System.out.println("Topic Usa Consumer: " + msg);
    }
}