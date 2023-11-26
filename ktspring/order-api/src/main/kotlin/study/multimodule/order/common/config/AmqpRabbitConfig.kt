package study.multimodule.order.common.config

import jakarta.annotation.PostConstruct
import org.springframework.amqp.core.AmqpAdmin
import org.springframework.amqp.core.BindingBuilder
import org.springframework.amqp.core.ExchangeBuilder
import org.springframework.amqp.core.QueueBuilder
import org.springframework.amqp.core.TopicExchange
import org.springframework.context.annotation.Configuration
import study.multimodule.order.common.util.AmqpRabbitUtils

@Configuration
class AmqpRabbitConfig(
    private val amqpAdmin: AmqpAdmin
) {

    @PostConstruct
    fun createQueues() {
        val myDefaultTopicExchange = ExchangeBuilder
            .topicExchange(AmqpRabbitUtils.Exchange.MY_DEFAULT_TOPIC)
            .build<TopicExchange>()

        amqpAdmin.declareExchange(myDefaultTopicExchange)

        // PAYMENT_BILLINGKEY_ISSUED queue 정의
        QueueBuilder
            .durable("${AmqpRabbitUtils.Queue.ORDER_PREIFIX}${AmqpRabbitUtils.RoutingKey.PAYMENT_BILLINGKEY_ISSUED}")
            .build()
            .let { queue ->
                amqpAdmin.declareQueue(queue)
                amqpAdmin.declareBinding(
                    BindingBuilder
                        .bind(queue)
                        .to(myDefaultTopicExchange)
                        .with(AmqpRabbitUtils.RoutingKey.PAYMENT_BILLINGKEY_ISSUED)
                )
            }
    }
}