package com.example.rabbitdemo4;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class RoutingProducer {
    private final RabbitTemplate template;

    @Autowired
    public RoutingProducer(RabbitTemplate template) {
        this.template = template;
    }

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Empty mapping";
    }

    @RequestMapping("/all")
    @ResponseBody
    String all() {
        first();
        second();
        third();
        return "Sent all";
    }

    @RequestMapping("/first")
    @ResponseBody
    String first() {
        log.info("Send as first");
        template.convertAndSend("direct-exchange-example-4","first", "first");
        return "Send as first";
    }

    @RequestMapping( "second")
    @ResponseBody
    String second() {
        log.info("Send as second");
        template.convertAndSend("direct-exchange-example-4","second", "second");
        return "Send as second";
    }

    @RequestMapping("/third")
    @ResponseBody
    String third() {
        log.info("Send as third");
        template.convertAndSend("direct-exchange-example-4","third", "third");
        return "Send as third";
    }

}