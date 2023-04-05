package study.flyway.domain.product.domain

import javax.persistence.*

@Table(name = "product")
@Entity
class Product(
    id: Long = 0,
    name: String,
    price: Long,
    stock: Long = 0,
    description: String?,
    category: String?,
    image: String?
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id = id

    @Column(name = "name", nullable = false, length = 100)
    val name = name

    @Column(name = "price", nullable = false)
    val price = price

    @Column(name = "stock", nullable = false)
    val stock = stock

    @Column(name = "description", length = 1000)
    val description = description

    @Column(name = "category", length = 100)
    val category = category

    @Column(name = "image", length = 200)
    val image = image
}