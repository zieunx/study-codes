package study.multimodule.order.common.util

class AmqpRabbitUtils {

    class Exchange {
        companion object {
            // exchange
            const val MY_DEFAULT_TOPIC = "my-default-topic-exchange"
        }
    }

    class Queue {
        companion object {
            // queue
            const val ORDER_PREIFIX = "order-"
        }
    }

    class RoutingKey {
        companion object {
            // routing-key
            const val PAYMENT_BILLINGKEY_ISSUED = "payment.billingkey.issued"
        }
    }
}