package com.ensk.demo.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicRabbitMqConfig {

    @Bean
    public Queue queueUsa() {
        return new Queue("test_queue_topic_usa");
    }

    @Bean
    public Queue queueNews() {
        return new Queue("test_queue_topic_news");
    }

    @Bean
    TopicExchange topicExchange() {
        return new TopicExchange("test_topic_exchange");
    }

    @Bean
    Binding bindingExchangeUsa(Queue queueUsa, TopicExchange topicExchange) {
        return BindingBuilder.bind(queueUsa).to(topicExchange).with("usa.#");
    }

    @Bean
    Binding bindingExchangeNews(Queue queueNews, TopicExchange topicExchange) {
        return BindingBuilder.bind(queueNews).to(topicExchange).with("#.news");
    }
}