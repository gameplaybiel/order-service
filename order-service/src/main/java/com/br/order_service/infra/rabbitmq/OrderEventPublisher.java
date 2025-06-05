package com.br.order_service.infra.rabbitmq;

import com.br.order_service.domain.model.Order;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderEventPublisher {
    private final RabbitTemplate rabbitTemplate;

    public OrderEventPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publishOrderCreate(Order order){
        rabbitTemplate.convertAndSend("order.create", order);
    }

    public void publishOrderDelete(Long orderId){
        rabbitTemplate.convertAndSend("order.delete", orderId);
    }
}
