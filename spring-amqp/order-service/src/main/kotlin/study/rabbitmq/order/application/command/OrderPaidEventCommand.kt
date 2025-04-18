package study.rabbitmq.order.application.command

import study.rabbitmq.order.contract.event.OrderPaidEvent
import java.math.BigDecimal

data class OrderPaidEventCommand(
    val orderId: String,
    val paidAmount: BigDecimal,
) {
    fun toEvent() = OrderPaidEvent(
        orderId = orderId,
        paidAmount = paidAmount,
    )
}
