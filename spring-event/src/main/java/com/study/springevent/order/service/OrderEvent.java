package com.study.springevent.order.service;

import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEvent;


@AllArgsConstructor
public class OrderEvent {
    private String orderId;
    private String userId;

    public String getOrderId() {
        return orderId;
    }

    public String getUserId() {
        return userId;
    }
}
