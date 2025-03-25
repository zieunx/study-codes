package study.rabbitmq.order.domain

import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.stereotype.Component

@Component
class OrderEventPublisher(
    private val rabbitTemplate: RabbitTemplate
) {

    fun publish(orderId: Long) {
        rabbitTemplate.convertAndSend("", "", "")
    }
}