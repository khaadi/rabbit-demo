package com.example.rabbitdemo3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication(scanBasePackages = "com.example.rabbitdemo3")
@Import(RabbitConfiguration.class)
class RabbitApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitApplication.class, args);
    }

}
