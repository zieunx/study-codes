package study.amqp.producer.order.service

import org.springframework.stereotype.Service
import study.amqp.producer.order.domain.OrderEventPublisher

@Service
class OrderService(
    private val orderEventPublisher: OrderEventPublisher
) {

    // 주문 결제처리
    fun paidOrder() {
        // ~ 주문 결제 처리 ~

        orderEventPublisher.publish(orderId = 1)
    }
}