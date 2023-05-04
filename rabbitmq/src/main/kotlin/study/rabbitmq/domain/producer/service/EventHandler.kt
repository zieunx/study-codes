package study.rabbitmq.domain.producer.service

import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.stereotype.Component
import study.rabbitmq.global.messaging.rabbitmq.RabbitMqQueue

@Component
class EventHandler(
    private val rabbitTemplate: RabbitTemplate
) {

    fun send(message: String) {
        rabbitTemplate.convertAndSend(RabbitMqQueue.TEST_QUEUE, message)
        println("Sent message: $message")
    }
}