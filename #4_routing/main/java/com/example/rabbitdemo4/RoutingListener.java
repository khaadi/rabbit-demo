package com.example.rabbitdemo4;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@EnableRabbit
@Component
@Slf4j
public class RoutingListener {
    @RabbitListener(queues = "queue4-1")
    public void worker1(String message) {
        log.info("accepted on worker 1 : " + message);
    }

    @RabbitListener(queues = "queue4-2")
    public void worker2(String message) {
        log.info("accepted on worker 2 : " + message);
    }

}
