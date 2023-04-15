package study.rabbitmq.domain.producer.service

import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.stereotype.Component

@Component
class EventHandler(
    val rabbitTemplate: RabbitTemplate
) {

    fun send(message: String) {
        rabbitTemplate.convertAndSend("", message)
        println("Sent message: $message")
    }
}