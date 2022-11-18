package com.study.springevent.domain.cart.domain;

import com.study.springevent.domain.cart.service.CartService;
import com.study.springevent.domain.order.domain.OrderEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@Component
@RequiredArgsConstructor
public class DeleteCartWithOrderEventHandler {
    private final CartService cartService;

    @EventListener
    public void deleteCart(OrderEvent event) {
        log.info("장바구니삭제 event listener handle 실행 - 1");
        cartService.deleteCart(event.getUserId());
    }

    /*
     * @TransactionalEventListener 사용에 대한 주의가 필요하다.
     * @EventListener 는 이벤트 전파가 가능하지만, @TransactionalEventListener 는 전파가 불가하다고 한다.
     * 해당 코드가 어떻게 내부적으로 동작하는지 확인 할 필요가 있다.
     * */
    @TransactionalEventListener
    public void deleteCartRecode(OrderEvent event) {
        log.info("장바구니삭제 event listener handle 실행 - 2");
    }
}
