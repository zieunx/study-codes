package study.kotlin.service

import io.ktor.client.*
import io.ktor.client.request.*
import org.springframework.stereotype.Service
import java.lang.Thread.sleep

@Service
class ProductClient(
    private val httpClient: HttpClient
) {

    suspend fun call() {
        sleep(1000)
        httpClient.post("https://www.naver.com/")
    }

    suspend fun call2() {
        sleep(2000)
        httpClient.post("https://www.naver.com/")
    }
}
