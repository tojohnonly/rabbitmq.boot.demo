package com.ensk.demo.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SimpleRabbitMqConfig {
    @Bean
    public Queue queueSimple() {
        return new Queue("test_queue_simple");
    }
}