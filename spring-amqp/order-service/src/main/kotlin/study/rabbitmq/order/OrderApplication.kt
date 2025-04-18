package study.rabbitmq.order

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["study.rabbitmq.order"])
class OrderApplication

fun main(args: Array<String>) {
    runApplication<OrderApplication>(*args)
}
