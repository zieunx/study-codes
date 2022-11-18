package com.study.springevent.domain.order.service;

import com.study.springevent.domain.cart.domain.Cart;
import com.study.springevent.domain.order.domain.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    public Order toOrder(Cart cart) {
        return new Order(cart.getUserId());
    }
}
