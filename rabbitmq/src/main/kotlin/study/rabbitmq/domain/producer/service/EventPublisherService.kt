package study.rabbitmq.domain.producer.service

import org.springframework.stereotype.Service

@Service
class EventPublisherService(
    private val eventHandler: EventHandler
) {

    fun publish() {
        eventHandler.send("메시지 발송")
    }
}