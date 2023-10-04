package com.eaxmple.rabbitdemo5;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class RabbitTopicConfiguration {

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory =
                new CachingConnectionFactory("localhost");
        return connectionFactory;
    }

    @Bean
    public AmqpAdmin amqpAdmin(@Qualifier("connectionFactory") ConnectionFactory connectionFactory) {
        return new RabbitAdmin(connectionFactory);
    }

    @Bean
    public RabbitTemplate rabbitTemplate(@Qualifier("connectionFactory") ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setExchange("topic-exchange-example");
        return template;
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange("topic-exchange-example");
    }

    @Bean
    public Queue myTopicQueue() {
        return new Queue("queue-5-1");
    }

    @Bean
    public Queue myTopicQueue2() {
        return new Queue("queue-5-2");
    }

    @Bean
    public Binding binding1(@Qualifier("myTopicQueue") Queue queue, TopicExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("insect.#");
    }

    @Bean
    public Binding binding2(@Qualifier("myTopicQueue2") Queue queue, TopicExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("*.mammal.*");
    }

    @Bean
    public Binding binding3(@Qualifier("myTopicQueue2") Queue queue, TopicExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("animal.#");
    }

}
