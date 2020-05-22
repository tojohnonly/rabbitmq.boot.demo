package com.ensk.demo.rabbitmq.controller;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicProducerController {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @RequestMapping("/topic/usa/news/send")
    public String sendUsaNews() {
        String content = "New for USA Topic Message, Date: " + new Date();
        amqpTemplate.convertAndSend("test_topic_exchange", "usa.news", content);
        return content;
    }

    @RequestMapping("/topic/china/news/send")
    public String sendChinaNews() {
        String content = "New for China Topic Message, Date: " + new Date();
        amqpTemplate.convertAndSend("test_topic_exchange", "china.news", content);
        return content;
    }

    @RequestMapping("/topic/usa/weather/send")
    public String sendUsaWeather() {
        String content = "Weather for USA Topic Message, Date: " + new Date();
        amqpTemplate.convertAndSend("test_topic_exchange", "usa.weather", content);
        return content;
    }
}