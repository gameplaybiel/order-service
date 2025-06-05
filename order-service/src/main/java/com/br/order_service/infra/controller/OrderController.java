package com.br.order_service.infra.controller;

import com.br.order_service.application.dto.CreateOrderDTO;
import com.br.order_service.application.usecase.OrderUseCase;
import com.br.order_service.domain.model.Order;
import com.br.order_service.infra.rabbitmq.OrderEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderUseCase orderUseCase;
    private final OrderEventPublisher orderEventPublisher;

    public OrderController(OrderUseCase orderUseCase, OrderEventPublisher orderEventPublisher) {
        this.orderUseCase = orderUseCase;
        this.orderEventPublisher = orderEventPublisher;
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody CreateOrderDTO dto) {
        Order order = orderUseCase.createOrder(dto);
        orderEventPublisher.publishOrderCreate(order);
        return ResponseEntity.ok(order);
    }

    @GetMapping("/{id}/existe")
    public ResponseEntity<Void> verificarExistencia(@PathVariable Long id) {
        return orderUseCase.existOrder(id)
                ? ResponseEntity.ok().build()
                : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Order>> listarOrders() {
        return ResponseEntity.ok(orderUseCase.listOrders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getById(@PathVariable Long id) {
        return ResponseEntity.ok(orderUseCase.getOrderById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        orderUseCase.deleteOrder(id);
        orderEventPublisher.publishOrderDelete(id);
        return ResponseEntity.noContent().build();
    }
}
