package com.ensk.demo.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutRabbitMqConfig {

    @Bean
    public Queue messageFanoutA() {
        return new Queue("test_queue_fanout_a");
    }

    @Bean
    public Queue messageFanoutB() {
        return new Queue("test_queue_fanout_b");
    }

    @Bean
    public Queue messageFanoutC() {
        return new Queue("test_queue_fanout_c");
    }

    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("test_fanout_exchange");
    }

    @Bean
    Binding bindingExchangeA(Queue messageFanoutA, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(messageFanoutA).to(fanoutExchange);
    }

    @Bean
    Binding bindingExchangeB(Queue messageFanoutB, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(messageFanoutB).to(fanoutExchange);
    }

    @Bean
    Binding bindingExchangeC(Queue messageFanoutC, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(messageFanoutC).to(fanoutExchange);
    }
}