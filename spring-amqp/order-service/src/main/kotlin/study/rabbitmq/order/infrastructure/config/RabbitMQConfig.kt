package study.rabbitmq.order.infrastructure.config

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.amqp.rabbit.annotation.EnableRabbit
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.amqp.support.converter.MessageConverter
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@EnableRabbit
@Configuration
class RabbitMQConfig {

    @Bean
    fun rabbitTemplate(
        connectionFactory: ConnectionFactory,
        messageConverter: MessageConverter,
    ): RabbitTemplate {
        val rabbitTemplate = RabbitTemplate(connectionFactory)

        rabbitTemplate.setConfirmCallback(confirmCallback())
        rabbitTemplate.messageConverter = messageConverter

        return rabbitTemplate
    }

    @Bean
    @ConditionalOnMissingBean
    fun messageConverter(objectMapper: ObjectMapper): MessageConverter {
        return Jackson2JsonMessageConverter(objectMapper.findAndRegisterModules())
    }

    private fun confirmCallback(): RabbitTemplate.ConfirmCallback =
        RabbitTemplate.ConfirmCallback { correlationData, ack, cause ->
            if (!ack) {
                println("❌ [NACK] Failed to send message: $cause")
            } else {
                println("✅ [ACK] Message sent successfully: ${correlationData?.id}")
            }
        }
}