package study.rabbitmq.order.application.command

import java.math.BigDecimal

data class OrderPaidCommand(
    val orderId: String,
    val paidAmount: BigDecimal,
)