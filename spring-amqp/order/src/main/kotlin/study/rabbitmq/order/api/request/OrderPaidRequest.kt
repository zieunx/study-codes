package study.rabbitmq.order.api.request

data class OrderPaidRequest(
    val orderId: String,
    val paidAmount: Long,
)