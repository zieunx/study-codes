package study.redis.domain.order.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CartProductTest {

    @Test
    void productCode_가_같으면_같은객체() {
        CartProduct productA = CartProduct.builder()
                .productCode("P0001")
                .name("상품A")
                .count(1)
                .price(1_000)
                .build();

        CartProduct productB = CartProduct.builder()
                .productCode("P0001")
                .name("상품A")
                .count(1)
                .price(1_000)
                .build();

        assertEquals(productA, productB);
    }

    @Test
    void productCode만_달라도_다른객체() {
        CartProduct productA = CartProduct.builder()
                .productCode("P0001")
                .name("상품A")
                .count(1)
                .price(1_000)
                .build();

        CartProduct productB = CartProduct.builder()
                .productCode("P0002")
                .name("상품A")
                .count(1)
                .price(1_000)
                .build();

        assertNotEquals(productA, productB);
    }
}