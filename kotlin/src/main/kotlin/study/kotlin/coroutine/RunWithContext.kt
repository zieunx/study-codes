package study.kotlin.coroutine

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Thread.sleep

suspend fun main() {
    suspend()
}

suspend fun suspend() {
    val scope = CoroutineScope(Dispatchers.IO)
    withContext(scope.coroutineContext) {
        callApi()
    }
}

suspend fun callApi(): HttpResponse {
    val httpClient = HttpClient()
    return httpClient.get("https://www.naver.com/")
}
