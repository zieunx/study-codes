package study.kotlin.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import study.kotlin.dto.ProductCreateRequest

@RestController
@RequestMapping("/product")
class ProductCreateController {

    @PostMapping
    fun createProduct(
        @RequestBody productCreateRequest: ProductCreateRequest
    ) {
        println("상품생성 요청 데이터: $productCreateRequest")
    }
}
