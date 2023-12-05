package study.multimodule.payment.api

import mu.KotlinLogging
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import study.multimodule.payment.api.dto.RequestPaymentBilling

@RequestMapping("/api/payments/billing")
@RestController
class BillingPaymentApi {
    val log = KotlinLogging.logger {}

    /**
     * 정기 결제 billing-key 발급 API
     */
    @PostMapping("/key/issue")
    fun issueBillingKey(
        @RequestBody requestPaymentBilling: RequestPaymentBilling
    ) {
        log.info { "[${this.javaClass.kotlin.simpleName}] issueBillingKey() /api/payments/billing/key/issue" }
    }

    /**
     * 정기 결제 요청 API
     */
    @PostMapping
    fun requestPayment() {
        log.info { "[${this.javaClass.kotlin.simpleName}] requestPayment() /api/payments/billing" }
    }
}
