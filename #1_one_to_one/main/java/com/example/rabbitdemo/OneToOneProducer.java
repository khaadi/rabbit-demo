package com.example.rabbitdemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class OneToOneProducer {

    @Autowired
    AmqpTemplate template;

    @RequestMapping("/emit")
    @ResponseBody
    String queue1() {
        log.info("Emit to queue1");
        template.convertAndSend("queue1","Message to queue");
        return "Emit to queue";
    }
}