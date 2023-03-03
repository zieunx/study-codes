package study.spring.jpa.product.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.UUID;


@Slf4j
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

    private Long stock;

    public Product(String name, Integer price, String description, UUID productCode) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public void minusStock() {
        if (stock <= 0) {
            throw new IllegalStateException("요청하신 상품의 재고가 소진되었습니다.");
        }
        stock -= 1;
        log.info("재고: {}", stock);
    }
}
