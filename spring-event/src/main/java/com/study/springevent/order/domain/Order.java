package com.study.springevent.order.domain;

import java.util.UUID;

public class Order {
    private String userId;
    private String orderId;

    public Order(String userId) {
        this.userId = userId;
        this.orderId = UUID.randomUUID().toString();
    }

    public String getUserId() {
        return userId;
    }

    public String getOrderId() {
        return orderId;
    }
}
