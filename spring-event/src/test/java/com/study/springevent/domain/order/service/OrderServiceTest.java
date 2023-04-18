package com.study.springevent.domain.order.service;

import com.study.springevent.domain.cart.domain.Cart;
import com.study.springevent.domain.order.domain.Order;
import com.study.springevent.domain.order.domain.OrderEvent;
import com.study.springevent.domain.order.domain.OrderRepository;
import com.study.springevent.event.EventTestSupport;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class OrderServiceTest extends EventTestSupport {

    @Mock
    private OrderMapper orderMapper;

    @Mock
    private OrderRepository orderRepository;

    @Autowired
    private OrderService orderService;

    @Test
    public void 주문이_완료되면_이벤트가_발행된다() {
        // given
        String userId = "userId";
        Order order = new Order(userId);
        when(orderMapper.toOrder(any())).thenReturn(order);
        when(orderRepository.save(any())).thenReturn(order);

        // when
        orderService.registerOrder(new Cart(userId));

        //then
        assertThat(testEventHandler.isSubscript(OrderEvent.class)).isTrue();
    }
}