package study.multimodule.payment.service

import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.stereotype.Service

@Service
class BillingPaymentService(
    val rabbitTemplate: RabbitTemplate
) {

    /**
     * billing-key 발급
     */
    fun issueBillingKey() {
        // PG사에 billing-key 발급을 받아온다.
        val billingKey = "billing-key"

        // save billing-key
        // event 발행
        rabbitTemplate.convertAndSend(
            "exchange",
            "routing-key",
            billingKey
        )
    }
}