package com.br.order_service.infra.rabbitmq;

import com.br.order_service.domain.model.StatusOrder;

public class OrderCreateEvent {
    private Long id;
    private Long clientId;
    private StatusOrder status;

    public OrderCreateEvent(Long id, Long clientId, StatusOrder status) {
        this.id = id;
        this.clientId = clientId;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public StatusOrder getStatus() {
        return status;
    }

    public void setStatus(StatusOrder status) {
        this.status = status;
    }
}
