package study.multimodule.order

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.scheduling.annotation.EnableAsync

@EnableAsync
@SpringBootApplication
class OrderApplication

fun main(args: Array<String>) {
    SpringApplication.run(OrderApplication::class.java, *args)
}