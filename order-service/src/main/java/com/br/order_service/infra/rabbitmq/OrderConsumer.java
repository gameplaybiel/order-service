package com.br.order_service.infra.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class OrderConsumer {
    @RabbitListener(queues = RabbitMQConfig.ORDER_CREATE_QUEUE)
    public void getOrderCreate(OrderCreateEvent event){
        System.out.println("Order received via messaging" + event.getId());
    }
}
