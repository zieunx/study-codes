package study.multimodule.payment.api

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import study.multimodule.payment.api.dto.RequestPaymentBilling

@RequestMapping("/api/payments/billing")
@RestController
class BillingPaymentApi {

    /**
     * 정기 결제 billing-key 발급 API
     */
    @PostMapping("/key/issue")
    fun issueBillingKey(
        @RequestBody requestPaymentBilling: RequestPaymentBilling
    ) {
        // TODO
    }

    /**
     * 정기 결제 요청 API
     */
    @PostMapping
    fun requestPayment() {
        // TODO
    }
}
