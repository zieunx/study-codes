package study.rabbitmq.domain.producer.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import study.rabbitmq.domain.producer.service.EventPublisherService

@RestController
class EventController(
    private val eventPublisherService: EventPublisherService
) {

    @PostMapping("publish")
    fun run() {
        eventPublisherService.publish()
    }
}