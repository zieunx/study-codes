package study.rabbitmq.domain.producer.config

import org.springframework.amqp.core.AmqpAdmin
import org.springframework.amqp.core.BindingBuilder
import org.springframework.amqp.core.ExchangeBuilder
import org.springframework.amqp.core.Queue
import org.springframework.amqp.core.QueueBuilder
import org.springframework.amqp.core.TopicExchange
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import study.rabbitmq.global.messaging.rabbitmq.RabbitMqExchange
import study.rabbitmq.global.messaging.rabbitmq.RabbitMqQueue
import study.rabbitmq.global.messaging.rabbitmq.RabbitMqRouteKey
import javax.annotation.PostConstruct

@Configuration
class RabbitMqConfig(
    private val amqpAdmin: AmqpAdmin
) {

    @PostConstruct
    fun createQueues() {
        val exchange = ExchangeBuilder.topicExchange(RabbitMqExchange.TEST_EXCHANGE)
            .build<TopicExchange>()
        amqpAdmin.declareExchange(exchange)

        QueueBuilder.durable(RabbitMqQueue.TEST_QUEUE)
            .build()
            .let {queue ->
                amqpAdmin.declareQueue(queue)
                amqpAdmin.declareBinding(
                    BindingBuilder.bind(queue)
                        .to(exchange)
                        .with(RabbitMqRouteKey.TEST_ROUTE_KEY)
                )
            }
    }

    @Bean
    fun queue1(): Queue {
        return Queue("queue1", false)
    }
}