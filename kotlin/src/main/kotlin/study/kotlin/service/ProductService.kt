package study.kotlin.service

import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import org.springframework.stereotype.Service

@Service
class ProductService(
    private val productClient: ProductClient
) {

    suspend fun callApi() {
        println("callApi Start")
        val result = coroutineScope {
            listOf(
                async { productClient.call() },
                async { productClient.call2() }
            ).awaitAll()
        }
        println("callApi End, result=$result")
    }
}
