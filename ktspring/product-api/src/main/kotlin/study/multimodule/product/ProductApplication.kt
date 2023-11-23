package study.multimodule.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync

@EnableAsync
@SpringBootApplication
class ProductApplication

fun main(args: Array<String>) {
    SpringApplication.run(ProductApplication::class.java, *args)
}