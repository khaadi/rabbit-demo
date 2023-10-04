package com.example.rabbitdemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@EnableRabbit
@Component
@Slf4j
public class OneToOneListener {

    @RabbitListener(queues = "queue1")
    public void processQueue1(String message) {
        log.info("Received from queue 1: " + message);

    }

}
