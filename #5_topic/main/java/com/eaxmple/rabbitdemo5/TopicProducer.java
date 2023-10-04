package com.eaxmple.rabbitdemo5;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class TopicProducer {
    private final RabbitTemplate template;

    @Autowired
    public TopicProducer(RabbitTemplate template) {
        this.template = template;
    }

    @RequestMapping("sent/{key}/{message}")
    @ResponseBody
    String error(@PathVariable("key") String key, @PathVariable("message") String message) {
        log.info(String.format("Emit '%s' to '%s'", message, key));
        template.convertAndSend("topic-exchange-example", key, message);
        return String.format("Emit '%s' to '%s'", message, key);
    }
}
