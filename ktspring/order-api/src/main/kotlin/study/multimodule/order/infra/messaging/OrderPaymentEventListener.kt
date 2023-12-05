package study.multimodule.order.infra.messaging

import mu.KotlinLogging
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component
import study.multimodule.order.common.util.AmqpRabbitUtils

@Component
class OrderPaymentEventListener {
    val log = KotlinLogging.logger {}

    @RabbitListener(queues = ["${AmqpRabbitUtils.Queue.ORDER_PREIFIX}${AmqpRabbitUtils.RoutingKey.PAYMENT_BILLINGKEY_ISSUED}"])
    fun receiveBillingKey(billingKey: String) {
        log.info { "[${this.javaClass.kotlin.simpleName}] receiveBillingKey() routing-key: payment.billingkey.issued, billingKey: $billingKey" }
    }
}