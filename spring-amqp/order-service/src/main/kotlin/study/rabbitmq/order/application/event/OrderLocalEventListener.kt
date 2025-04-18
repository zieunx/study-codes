package study.rabbitmq.order.application.event

import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.stereotype.Service
import org.springframework.transaction.event.TransactionalEventListener
import study.rabbitmq.order.contract.event.OrderPaidEvent
import study.rabbitmq.order.contract.event.OrderRoutingKeys

@Service
class OrderLocalEventListener(
    private val rabbitTemplate: RabbitTemplate,
) {

    @TransactionalEventListener
    fun publishRabbit(payload: OrderPaidEvent) {
        println("OrderLocalEventListener order paid: $payload")
        rabbitTemplate.convertAndSend(OrderRoutingKeys.ORDER_PAID, payload)
    }
}