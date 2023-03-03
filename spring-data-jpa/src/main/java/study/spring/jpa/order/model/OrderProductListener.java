package study.spring.jpa.order.model;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import study.spring.jpa.product.model.OrderProductEvent;

@Slf4j
public class OrderProductListener {

    @EventListener
    public void orderProduct(OrderProductEvent event) {
        log.debug("이벤트 리슨..");
    }
}
