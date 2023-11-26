package study.multimodule.order.api

import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import study.multimodule.order.service.OrderService

@RequestMapping("/api/orders")
@RestController
class OrderApi(
    private val orderService: OrderService
) {

    /**
     * 주문 결제 시작 API
     */
    @PostMapping("/payment/{idKey}/start")
    fun startOrderPayment(
        @PathVariable("idKey") idKey: String
    ) {
        orderService.startOrderPayment(idKey = idKey)
    }

    /**
     * 주문 결제 완료 API
     */
    @PostMapping("/payment/{idKey}/success")
    fun successOrderPayment(
        @PathVariable("idKey") idKey: String
    ) {
        orderService.completeOrderPayment(idKey = idKey)
    }
}