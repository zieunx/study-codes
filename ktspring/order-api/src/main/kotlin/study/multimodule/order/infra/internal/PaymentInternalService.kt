package study.multimodule.order.infra.internal

import org.springframework.stereotype.Service
import study.multimodule.order.dto.PaymentApproveDto
import study.multimodule.order.dto.PaymentIssueBillingKeyDto
import study.multimodule.order.service.PaymentService

@Service
class PaymentInternalService : PaymentService {
    override fun issueBillingKey(requestDto: PaymentIssueBillingKeyDto.Request): Result<Unit> {
        TODO("Not yet implemented")
    }

    override fun requestApprovePayment(requestDto: PaymentApproveDto.Request): Result<Unit> {
        TODO("Not yet implemented")
    }
}