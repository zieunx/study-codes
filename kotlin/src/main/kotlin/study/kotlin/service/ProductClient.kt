package study.kotlin.service

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import org.springframework.stereotype.Service

@Service
class ProductClient {

    private val httpClient = HttpClient(CIO)

    suspend fun call() = coroutineScope {
        async {
            delay(1000)
            httpClient.post<Unit>("https://www.naver.com/")
        }
    }

    suspend fun call2() = coroutineScope {
        async {
            delay(2000)
            httpClient.post<Unit>("https://www.naver.com/")
        }
    }
}
