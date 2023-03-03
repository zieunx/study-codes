package study.spring.jpa.product.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "product")
public class Product {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Basic(optional = false)
    private String name;

    private Integer price;

    @Lob
    private String description;

    @Column(length = 16)
    private UUID productCode;

    private Long stock;

    public Product(String name, Integer price, String description, UUID productCode) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.productCode = productCode;
    }

    public void minusStock() {
        if (stock <= 0) {
            throw new IllegalStateException("요청하신 상품의 재고가 소진되었습니다.");
        }
        stock -= 1;
    }
}
