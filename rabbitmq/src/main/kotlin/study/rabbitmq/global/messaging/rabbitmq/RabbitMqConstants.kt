package study.rabbitmq.global.messaging.rabbitmq


enum class RabbitMqExchange(
    val value: String
) {
    TEST_EXCHANGE("test.exchange")
}

enum class RabbitMqQueue(
    val value: String
) {
    TEST_QUEUE("test.queue")
}

enum class RabbitMqRouteKey(
    val value: String
) {
    TEST_ROUTE_KEY("test.route_key")
}