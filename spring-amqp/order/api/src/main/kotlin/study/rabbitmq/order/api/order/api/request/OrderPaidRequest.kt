package study.amqp.producer.order.api.request

data class OrderPaidRequest(
    val orderId: String,
    val paidAmount: Long,
)