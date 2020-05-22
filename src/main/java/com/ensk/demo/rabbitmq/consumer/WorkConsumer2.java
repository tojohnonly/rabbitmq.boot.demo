package com.ensk.demo.rabbitmq.consumer;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RabbitListener(queues = "test_queue_work")
public class WorkConsumer2 {

    @RabbitHandler
    public void receiver(String msg) {
        System.out.println("Work Consumer-2: " + msg);
    }

    /* 公平模式，需要开启application.properties里面的配置文件
    @RabbitHandler
    public void receiver(String msg, Channel channel, Message message) throws InterruptedException, IOException {
        System.out.println("Work Consumer-2: " + msg);
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }
    */
}