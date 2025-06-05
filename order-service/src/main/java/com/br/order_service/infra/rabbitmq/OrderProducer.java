package com.br.order_service.infra.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class OrderProducer {
    private final RabbitTemplate rabbitTemplate;

    public OrderProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendOrderCreate(OrderCreateEvent event){
        rabbitTemplate.convertAndSend(
                RabbitMQConfig.ORDER_EXCHANHE,
                RabbitMQConfig.ORDER_ROUTING_KEY,
                event
        );
    }
}
