package com.br.order_service.infra.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    public static final String ORDER_CREATE_QUEUE = "order.create.queue";
    public static final String ORDER_EXCHANHE = "order.exchange";
    public static final String ORDER_ROUTING_KEY = "order.create";

    @Bean
    public Queue orderQueue(){
        return new Queue(ORDER_CREATE_QUEUE, true);
    }

    @Bean
    public DirectExchange orderExchange(){
        return new DirectExchange(ORDER_EXCHANHE);
    }

    @Bean
    public Binding binding(Queue orderQueue, DirectExchange orderExchange){
        return BindingBuilder.bind(orderQueue).to(orderExchange).with(ORDER_ROUTING_KEY);
    }
}
