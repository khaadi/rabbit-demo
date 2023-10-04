package com.example.rabbitdemo4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication(scanBasePackages = "com.example.rabbitdemo4")
@Import(RabbitRoutingConfiguration.class)
public class RabbitRoutingApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitRoutingApplication.class, args);
    }

}
