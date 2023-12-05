package study.multimodule.order.infra.internal

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.client.request.*
import kotlinx.coroutines.runBlocking
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import study.multimodule.order.dto.PaymentApproveDto
import study.multimodule.order.dto.PaymentIssueBillingKeyDto
import study.multimodule.order.service.PaymentService

@Service
class PaymentInternalService(
    private val httpClient: HttpClient,
    @Value("internal-api.payment-url")
    private val internalPaymentUrl: String,
) : PaymentService {
    override fun issueBillingKey(requestDto: PaymentIssueBillingKeyDto.Request): Result<Unit> = runCatching {
        runBlocking {
            httpClient.post("$internalPaymentUrl/api/internal/payment/billing/key/issue")
                .body()
        }
    }

    override fun requestApprovePayment(requestDto: PaymentApproveDto.Request): Result<Unit> = runCatching {
        runBlocking {
            httpClient.post("$internalPaymentUrl/api/internal/payment/billing/approve/${requestDto.idKey}")
                .body()
        }
    }
}