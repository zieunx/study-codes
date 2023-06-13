package study.rabbitmq.domain.consumer.messaging

import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component
import study.rabbitmq.global.messaging.rabbitmq.RabbitMqQueue

@Component
class EventListener {

    @RabbitListener(queues = [RabbitMqQueue.TEST_QUEUE])
    fun listen(@Payload payload: String) {
        println("[consumer] listen payload = $payload")
    }
}