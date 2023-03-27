package study.kotlin.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import study.kotlin.dto.ProductCreateRequest
import study.kotlin.dto.ProductNotNullRequest
import javax.validation.Valid

@RestController
@RequestMapping("/product")
class ProductCreateController {

    @PostMapping
    fun createProduct(
        @RequestBody @Valid productCreateRequest: ProductNotNullRequest
    ) {
        println("상품생성 요청 데이터: $productCreateRequest")
    }
}
