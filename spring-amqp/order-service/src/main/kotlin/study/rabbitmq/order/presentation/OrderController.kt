package study.rabbitmq.order.presentation

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import study.rabbitmq.order.presentation.request.OrderPaidRequest
import study.rabbitmq.order.application.service.OrderPayService

@RestController
@RequestMapping("/api/order")
class OrderController(
    private val orderPayService: OrderPayService,
) {

    @PostMapping("/paid")
    fun paid(@RequestBody orderRequest: OrderPaidRequest) {
        orderPayService.paidOrder(orderRequest.toCommand())
    }
}