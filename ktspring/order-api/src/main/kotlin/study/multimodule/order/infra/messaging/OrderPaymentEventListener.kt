package study.multimodule.order.infra.messaging

import org.springframework.amqp.rabbit.annotation.RabbitListener
import study.multimodule.order.common.util.AmqpRabbitUtils

class OrderPaymentEventListener {
    @RabbitListener(queues = ["${AmqpRabbitUtils.Queue.ORDER_PREIFIX}${AmqpRabbitUtils.RoutingKey.PAYMENT_BILLINGKEY_ISSUED}"])
    fun receiveBillingKey(billingKey: String) {

    }
}