package com.study.springevent.order.service;

import com.study.springevent.cart.domain.Cart;
//import com.study.springevent.cart.domain.CartRepository;
import com.study.springevent.order.domain.Order;
import com.study.springevent.order.domain.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OrderService {
    private final OrderMapper orderMapper;
    private final OrderRepository orderRepository;
    private final ApplicationEventPublisher applicationEventPublisher;
//    private final CartRepository cartRepository;

    public void registerOrder(Cart cart) {
        // 주문 데이터 생성
        Order order = orderMapper.toOrder(cart);
        orderRepository.save(order);

//        cartRepository.delete(cart); // 주문과 강결합 되어있는 'cart 삭제' 로직
        applicationEventPublisher.publishEvent(new OrderEvent(this, order.getUserId()));
        // 주문 이벤트를 발생한다. 해당 이벤트를 구독하는 핸들러들이 실행된다.
    }
}
