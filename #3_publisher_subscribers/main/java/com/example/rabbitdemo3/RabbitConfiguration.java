package com.example.rabbitdemo3;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

class RabbitConfiguration {

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
        return new RabbitTemplate(connectionFactory);
    }

    @Bean
    public Queue myQueue1() {
        return new Queue("queue3-1");
    }

    @Bean
    public Queue myQueue2() {
        return new Queue("queue3-2");
    }

    @Bean
    public FanoutExchange fanoutExchangeA(){
        return new FanoutExchange("exchange-example-3");
    }

    @Bean
    @Qualifier("fanoutExchange1")
    public Binding binding1(@Qualifier("myQueue1") Queue queue, FanoutExchange exchange){
        return BindingBuilder.bind(queue).to(exchange);
    }

    @Bean
    @Qualifier("fanoutExchange1")
    public Binding binding2(@Qualifier("myQueue2") Queue queue, FanoutExchange exchange){
        return BindingBuilder.bind(queue).to(exchange);
    }

}