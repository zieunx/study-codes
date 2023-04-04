package study.flyway.domain.product.service

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import study.flyway.domain.product.domain.Product
import study.flyway.domain.product.dto.ProductCreateRequest
import study.flyway.domain.product.repository.ProductRepository

@Service
class ProductService(
    private val productRepository: ProductRepository,
) {

    @Transactional
    fun createProduct(request: ProductCreateRequest) {
        val product = Product(
            name = request.name,
            price = request.price,
            stock = request.stock,
            description = request.description,
            category = request.category,
            image = request.image,
        )

        productRepository.save(product)
    }
}