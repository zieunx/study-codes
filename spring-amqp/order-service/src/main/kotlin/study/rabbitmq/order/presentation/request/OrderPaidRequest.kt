package study.rabbitmq.order.presentation.request

import study.rabbitmq.order.application.command.OrderPaidCommand
import java.math.BigDecimal

data class OrderPaidRequest(
    val orderId: String,
    val paidAmount: BigDecimal,
) {
    fun toCommand(): OrderPaidCommand = OrderPaidCommand(
        orderId = orderId,
        paidAmount = paidAmount,
    )
}