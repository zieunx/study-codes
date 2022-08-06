package com.study.springevent.order.service;

import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEvent;


public class OrderEvent extends ApplicationEvent {
    private String orderId;
    private String userId;



    public OrderEvent(Object source, String message) {
        super(source);
        this.userId = message;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getUserId() {
        return userId;
    }
}
