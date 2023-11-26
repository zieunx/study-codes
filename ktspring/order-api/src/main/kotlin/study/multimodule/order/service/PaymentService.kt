package study.multimodule.order.service

import study.multimodule.order.dto.PaymentApproveDto
import study.multimodule.order.dto.PaymentIssueBillingKeyDto

interface PaymentService {
    fun issueBillingKey(
        requestDto: PaymentIssueBillingKeyDto.Request,
    ): Result<Unit>
    fun requestApprovePayment(
        requestDto: PaymentApproveDto.Request,
    ): Result<Unit>
}