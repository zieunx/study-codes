package study.flyway.domain.product.repository

import org.springframework.data.jpa.repository.JpaRepository
import study.flyway.domain.product.domain.Product

interface ProductRepository: JpaRepository<Product, Long> {
}