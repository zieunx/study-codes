package study.rabbitmq.order.contract.event

import study.rabbitmq.contract.event.BaseDomainEvent

sealed class OrderEvent(
    open val orderId: String
) : BaseDomainEvent()