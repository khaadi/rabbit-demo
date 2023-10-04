package com.example.rabbitdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication(scanBasePackages = "com.example.rabbitdemo")
@Import(RabbitConfiguration.class)
public class RabbitDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitDemoApplication.class, args);
    }

}
