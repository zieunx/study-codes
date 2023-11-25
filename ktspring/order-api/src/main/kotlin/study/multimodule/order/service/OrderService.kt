package study.multimodule.order.service

import org.springframework.stereotype.Service

@Service
class OrderService(
    private val paymentService: PaymentService
) {

    fun startOrderPayment() {
        paymentService.issueBillingKey()
    }
}