package study.kotlin.dto

import javax.validation.constraints.NotNull

data class ProductCreateRequest (
    @field:NotNull(message = "상품명은 필수값입니다.")
    val productName: String
)
