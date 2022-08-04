package com.study.springevent.order.service;

import com.study.springevent.cart.domain.Cart;
import com.study.springevent.order.domain.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    public Order toOrder(Cart cart) {
        return new Order(cart.getUserId());
    }
}
