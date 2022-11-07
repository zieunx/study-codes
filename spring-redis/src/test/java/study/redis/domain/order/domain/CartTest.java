package study.redis.domain.order.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CartTest {

    @Test
    void 같은_상품_2개이상_추가하면_수량만_더해진다() {
        // when
        Cart cart = Cart.init("memberA");

        CartProduct cartProductA = CartProduct.builder()
                .productCode("P0001")
                .name("상품A")
                .count(1)
                .price(1_000)
                .build();

        CartProduct cartProductB = CartProduct.builder()
                .productCode("P0001")
                .name("상품A")
                .count(1)
                .price(1_000)
                .build();

        // given
        cart.addProduct(cartProductA);
        cart.addProduct(cartProductB);

        // then
        CartProduct cartProduct = cart.findCartProductByProductCode("P0001")
                .orElseThrow(() -> new IllegalStateException("장바구니 상품을 찾을 수 없음."));

        assertThat(cartProduct).isEqualTo(CartProduct.create("P0001"));
        assertThat(cartProduct.getCount()).isEqualTo(2);
    }
}