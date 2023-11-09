package study.kotlin.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import study.kotlin.dto.ProductNoneNullRequest
import study.kotlin.dto.ProductNullableRequest
import study.kotlin.service.ProductService
import javax.validation.Valid

@RestController
@RequestMapping("/product")
class ProductCreateController(
    private val productService: ProductService
) {

    @PostMapping("/none-null")
    fun createProductByNoneNullProperties(
        @RequestBody @Valid productCreateRequest: ProductNoneNullRequest
    ) {
        println("상품생성 요청 데이터: $productCreateRequest")
    }

    @PostMapping("/nullable")
    fun createProductByNullableProperties(
        @RequestBody @Valid productCreateRequest: ProductNullableRequest
    ) {
        println("상품생성 요청 데이터: $productCreateRequest")
    }

    @PostMapping("/connect")
    suspend fun connectMultiApi() {
        productService.callApi()
    }
}
