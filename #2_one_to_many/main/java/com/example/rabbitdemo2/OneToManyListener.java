package com.example.rabbitdemo2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Random;

@EnableRabbit
@Component
@Slf4j
public class OneToManyListener {

    Random random = new Random();

    @RabbitListener(queues = "queue-2")
    public void worker1(String message) throws InterruptedException {
        log.info("worker 1 : " + message);
        Thread.sleep(100 * random.nextInt(20));
    }

    @RabbitListener(queues = "queue-2")
    public void worker2(String message) throws InterruptedException {
        log.info("worker 2 : " + message);
        Thread.sleep(100 * random.nextInt(20));
    }
}
