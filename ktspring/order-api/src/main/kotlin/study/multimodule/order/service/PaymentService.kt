package study.multimodule.order.service

import org.springframework.stereotype.Service

@Service
interface PaymentService {
    fun issueBillingKey()
    fun requestPayment()
}