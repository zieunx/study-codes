package study.rabbitmq.order.application.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import study.rabbitmq.order.application.command.OrderPaidEventCommand
import study.rabbitmq.order.application.command.OrderPaidCommand
import study.rabbitmq.order.application.event.OrderEventPublisher

@Service
class OrderPayService(
    private val orderEventPublisher: OrderEventPublisher
) {

    // 주문 결제처리
    @Transactional
    fun paidOrder(command: OrderPaidCommand) {
        // ~ 주문 결ㅊ제 처리 (중략) ~

        orderEventPublisher.publish(
            OrderPaidEventCommand(
                orderId = command.orderId,
                paidAmount = command.paidAmount,
            )
        )
    }
}