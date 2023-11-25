package study.multimodule.order.api

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/orders")
@RestController
class OrderApi {

    /**
     * 주문 결제 시작 API
     */
    @PostMapping("/payment")
    fun startOrderPayment() {
        // TODO
        /**
         * 주문 검증
         * external: billing-key 발급 요청 API
         */
    }

    /**
     * 주문 결제 완료 API
     */
    @PostMapping("/payment/success")
    fun successOrderPayment() {
        // TODO: 주문 결제 완료 처리
    }
}