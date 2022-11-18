package com.study.springevent.domain.order.controller;

import com.study.springevent.domain.cart.domain.Cart;
import com.study.springevent.domain.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("order")
@RestController
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<?> registerOrder() {
        return ResponseEntity.ok(orderService.registerOrder(new Cart("이지은")).getOrderId());
    }
}
