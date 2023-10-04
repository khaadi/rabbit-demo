package com.example.rabbitdemo2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication(scanBasePackages = "com.example.rabbitdemo2")
@Import(RabbitOneToManyApplication.class)
public class RabbitOneToManyApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitOneToManyApplication.class);
    }

}
