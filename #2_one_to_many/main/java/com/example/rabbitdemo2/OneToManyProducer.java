package com.example.rabbitdemo2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class OneToManyProducer {
    private final AmqpTemplate template;

    @Autowired
    public OneToManyProducer(AmqpTemplate template) {
        this.template = template;
    }

    @RequestMapping("/run")
    @ResponseBody
    String queue1() {
        log.info("Queue 2 is running!");
        for (int i = 0;i < 100; i++) {
            template.convertAndSend("queue-2", "Message of queue #" + i);
        }
        return "Queue 2 is running!";
    }
}