package com.eaxmple.rabbitdemo5;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableRabbit
@Import(RabbitTopicConfiguration.class)
public class RabbitTopicApplication {
    public static void main(String[] args) {
        SpringApplication.run(RabbitTopicApplication.class, args);
    }
}
