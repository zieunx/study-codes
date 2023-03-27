package study.kotlin.dto

import javax.validation.constraints.NotBlank

data class ProductNotNullRequest (
    @field:NotBlank(message = "상품명은 필수값입니다.")
    val productName: String
)
