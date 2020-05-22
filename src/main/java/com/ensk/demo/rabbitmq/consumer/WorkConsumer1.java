package com.ensk.demo.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "test_queue_work")
public class WorkConsumer1 {

    @RabbitHandler
    public void receiver(String msg) {
        System.out.println("Work Consumer-1: " + msg);
    }

    /* 公平模式，需要开启application.properties里面的配置文件
    @RabbitHandler
    public void receiver(String msg, Channel channel, Message message) throws InterruptedException, IOException {
        Thread.sleep(1000);
        System.out.println("Work Consumer-1: " + msg);
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }
     */
}