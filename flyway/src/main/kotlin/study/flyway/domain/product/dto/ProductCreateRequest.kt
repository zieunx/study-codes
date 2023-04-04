package study.flyway.domain.product.dto

data class ProductCreateRequest(
    val name: String,
    val price: Long,
    val stock: Long,
    val description: String,
    val category: String,
    val image: String,
)