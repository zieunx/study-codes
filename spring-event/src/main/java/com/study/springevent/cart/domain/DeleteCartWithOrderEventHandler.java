package com.study.springevent.cart.domain;

import com.study.springevent.cart.service.CartService;
import com.study.springevent.order.service.OrderEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class DeleteCartWithOrderEventHandler {
    private final CartService cartService;

    @EventListener(OrderEvent.class)
    public void handle(OrderEvent event) {
        log.info("DeleteCartWithOrderEventHandler handle 실행");
        cartService.deleteCart(event.getUserId());
    }
}
