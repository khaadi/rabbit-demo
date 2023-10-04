package com.eaxmple.rabbitdemo5;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TopicListener {
    @RabbitListener(queues = "queue-5-1")
    public void worker1(String message) {
        log.info("insects listener " + message);
    }

    @RabbitListener(queues = "queue-5-2")
    public void worker2(String message) {
        log.info("animals listener " + message);
    }

}
