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
    private val amqpAdmin: AmqpAdmin,
) {

    @PostConstruct
    fun createQueues() {
        val exchange = ExchangeBuilder.topicExchange(RabbitMqExchange.TEST_EXCHANGE)
            .build<TopicExchange>()
        amqpAdmin.declareExchange(exchange)

        QueueBuilder.durable(RabbitMqQueue.TEST_QUEUE)
            .build()
            .let { queue ->
                amqpAdmin.declareQueue(queue)
                amqpAdmin.declareBinding(
                    BindingBuilder.bind(queue)
                        .to(exchange)
                        .with(RabbitMqRouteKey.TEST_ROUTE_KEY),
                )
            }
    }

    @Bean
    fun queue1(): Queue {
        return Queue("queue1", false)
    }

    @Bean
    fun ttl5Queue(): Queue {
        return ttlQueue("ttl5Queue", "myExchange", 5000)
    }

    fun ttlQueue(
        queueName: String, // 해당 ttl Queue 이름
        exchangeName: String,
        ttl: Int,
    ): Queue {
        val arguments = mapOf(
            "x-dead-letter-exchange" to exchangeName, // 전송 될 Exchange
            "x-message-ttl" to ttl, // 지연 시간
            // "x-dead-letter-routing-key" to "지연된 메시지가 전송 될 라우팅 키"
        )
        return Queue(queueName, false, false, false, arguments)
    }
}
