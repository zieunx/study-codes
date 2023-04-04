package study.flyway.domain.product.domain

import javax.persistence.*

@Table(name = "product")
@Entity
class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,

    @Column(name = "name", nullable = false, length = 100)
    val name: String,

    @Column(name = "price", nullable = false)
    val price: Long,

    @Column(name = "stock", nullable = false)
    val stock: Long,

    @Column(name = "description", nullable = false, length = 1000)
    val description: String,

    @Column(name = "price", nullable = false, length = 100)
    val category: String,

    @Column(name = "image", nullable = false, length = 200)
    val image: String,
)