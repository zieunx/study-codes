package study.rabbitmq.order.application.event

import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service
import study.rabbitmq.order.contract.event.OrderPaidEvent
import study.rabbitmq.order.application.command.OrderPaidEventCommand

/**
 * 주문 도메인 내 이벤트 발행 처리
 */
@Service
class OrderEventPublisher(
    private val applicationEventPublisher: ApplicationEventPublisher,
) {

    fun publish(command: OrderPaidEventCommand) {
        applicationEventPublisher.publishEvent(
            OrderPaidEvent(orderId = command.orderId, paidAmount = command.paidAmount)
        )
    }
}