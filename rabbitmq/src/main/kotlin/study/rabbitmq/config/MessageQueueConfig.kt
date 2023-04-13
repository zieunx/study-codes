package study.rabbitmq.config

import org.springframework.amqp.core.Queue
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class MessageQueueConfig {

    @Bean
    fun queue1(): Queue {
        return Queue("queue1", false)
    }
}