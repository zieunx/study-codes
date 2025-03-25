package study.rabbitmq.notification.worker.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/notification")
@RestController
class NotificationController {

    @PostMapping
    fun sendNotification() {
        println("Send notification")
    }
}