package com.study.springevent.domain.order.domain;

public class OrderEvent {
    private Long orderId;
    private String userId;

    public OrderEvent(Long orderId, String userId) {
        this.orderId = orderId;
        this.userId = userId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public String getUserId() {
        return userId;
    }
}
