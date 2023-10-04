package com.example.rabbitdemo3;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
class Producer {
    private final RabbitTemplate template;

    @Autowired
    public Producer(RabbitTemplate template) {
        this.template = template;
    }

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Empty mapping";
    }

    @RequestMapping("/run3")
    @ResponseBody
    String run() {
        log.info("Emit to exchange-example-3");
        template.setExchange("exchange-example-3");
        template.convertAndSend("Sent fanout message");
        return "Run to exchange-example-3";
    }
}