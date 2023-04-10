package study.kotlin.service

import org.springframework.stereotype.Service

@Service
class ProductService(
    private val productClient: ProductClient
) {

    suspend fun callApi() {
        productClient.call()
        productClient.call2()
    }
}
