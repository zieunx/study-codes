package com.study.springevent.domain.order.service;

import com.study.springevent.domain.cart.domain.Cart;
import com.study.springevent.domain.order.domain.Order;
import com.study.springevent.domain.order.domain.OrderEvent;
import com.study.springevent.domain.order.domain.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class OrderService {
    private final OrderMapper orderMapper;
    private final OrderRepository orderRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    @Transactional
    public Order registerOrder(Cart cart) {
        // 주문 데이터 생성
        Order order = orderMapper.toOrder(cart);
        orderRepository.save(order);

        log.info("주문 이벤트 발행 ----->");
        applicationEventPublisher.publishEvent(new OrderEvent(order.getOrderId(), order.getUserId()));
        log.info("-----> 주문완료");

        return order;
    }
}
