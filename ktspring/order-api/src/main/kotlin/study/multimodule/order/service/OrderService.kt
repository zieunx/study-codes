package study.multimodule.order.service

import org.springframework.stereotype.Service
import study.multimodule.order.dto.PaymentApproveDto
import study.multimodule.order.dto.PaymentIssueBillingKeyDto

@Service
class OrderService(
    private val paymentService: PaymentService
) {

    /**
     * 주문 결제 시작
     */
    fun startOrderPayment(idKey: String) {
        paymentService.issueBillingKey(
            requestDto = PaymentIssueBillingKeyDto.Request(
                idKey = idKey,
            )
        )
    }

    /**
     * 주문 결제 완료
     */
    fun completeOrderPayment(idKey: String) {
        // 주문 완료처리
        // ...
        // ...

        paymentService.requestApprovePayment(
            requestDto = PaymentApproveDto.Request(
                idKey = idKey,
            ),
        ).getOrThrow()
    }
}