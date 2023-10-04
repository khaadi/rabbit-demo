package com.example.rabbitdemo4;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

public class RabbitRoutingConfiguration {

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
        return new Queue("queue_4_1");
    }

    @Bean
    public Queue myQueue2() {
        return new Queue("queue_4_1");
    }

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("direct-exchange-example-4");
    }

    @Bean
    public Binding binding_1_1(@Qualifier("myQueue1") Queue queue, @Qualifier("directExchange")DirectExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("first");
    }

    @Bean
    public Binding binding_2_1(@Qualifier("myQueue2") Queue queue, @Qualifier("directExchange")DirectExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("first");
    }

    @Bean
    public Binding binding_2_2(@Qualifier("myQueue2") Queue queue, @Qualifier("directExchange")DirectExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("second");
    }

    @Bean
    public Binding binding_2_3(@Qualifier("myQueue2") Queue queue, @Qualifier("directExchange")DirectExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("third");
    }

}