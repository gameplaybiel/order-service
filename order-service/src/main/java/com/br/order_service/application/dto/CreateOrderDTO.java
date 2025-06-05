package com.br.order_service.application.dto;

import com.br.order_service.domain.model.StatusOrder;

public class CreateOrderDTO {
    private Long clientId;
    private StatusOrder status;

    public CreateOrderDTO(){}

    public CreateOrderDTO(Long clientId, StatusOrder status) {
        this.clientId = clientId;
        this.status = status;
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
