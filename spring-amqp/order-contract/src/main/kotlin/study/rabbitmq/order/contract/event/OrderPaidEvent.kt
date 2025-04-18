package study.rabbitmq.order.contract.event

import java.math.BigDecimal

data class OrderPaidEvent (
    override val orderId: String,
    val paidAmount: BigDecimal,
): OrderEvent(
    orderId = orderId,
)