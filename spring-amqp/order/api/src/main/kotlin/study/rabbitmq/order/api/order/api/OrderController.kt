package study.amqp.producer.order.api

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import study.amqp.producer.order.api.request.OrderPaidRequest
import study.amqp.producer.order.service.OrderService

@RestController
@RequestMapping("/api/order")
class OrderController(
    private val orderService: OrderService,
) {

    @PostMapping("/paid")
    fun paid(@RequestBody orderDto: OrderPaidRequest) {
        orderService.paidOrder()
    }
}