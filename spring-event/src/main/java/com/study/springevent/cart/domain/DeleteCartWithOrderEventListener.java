package com.study.springevent.cart.domain;

import com.study.springevent.cart.service.CartService;
import com.study.springevent.order.service.OrderEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class DeleteCartWithOrderEventListener implements ApplicationListener<OrderEvent> {
    private final CartService cartService;

    @Override
    public void onApplicationEvent(OrderEvent event) {
        log.info("DeleteCartWithOrderEventListener onApplicationEvent 실행");
        cartService.deleteCart(event.getUserId());
    }
}
