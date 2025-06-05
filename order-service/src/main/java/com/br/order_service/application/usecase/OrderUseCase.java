package com.br.order_service.application.usecase;

import com.br.order_service.application.dto.CreateOrderDTO;
import com.br.order_service.domain.model.Order;
import com.br.order_service.domain.repository.OrderRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderUseCase {
    private final OrderRepository orderRepository;

    public OrderUseCase(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrder(CreateOrderDTO dto){
        if(dto.getClientId() == null){
            throw new IllegalArgumentException("Id of client cannot null");
        }
        Order order = new Order(dto.getClientId(), dto.getStatus());
        return orderRepository.save(order);
    }

    public Order getOrderById(Long id){
        return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found with id" + id));
    }

    public boolean existOrder(Long id) {
        return orderRepository.existsById(id);
    }

    public List<Order> listOrders(){
        return orderRepository.findAll();
    }

    public void deleteOrder(Long id){
        orderRepository.deleteById(id);
    }
}
