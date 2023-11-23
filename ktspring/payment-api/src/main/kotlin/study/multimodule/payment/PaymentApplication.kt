package study.multimodule.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync

@EnableAsync
@SpringBootApplication
class PaymentApplication

fun main(args: Array<String>) {
    SpringApplication.run(PaymentApplication::class.java, *args)
}