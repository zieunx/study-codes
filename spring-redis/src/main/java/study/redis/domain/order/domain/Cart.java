package study.redis.domain.order.domain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RedisHash(value = "cart", timeToLive = 1)
public class Cart {

    @Id
    private String cartId;
    private final LocalDateTime createdAt;
    private final List<CartProduct> cartProducts;

    private Cart(String cartId) {
        this.cartId = cartId;
        this.cartProducts = makeEmptyCart();
        this.createdAt = LocalDateTime.now();
    }

    public Cart(String cartId, List<CartProduct> cartProducts) {
        this.cartId = cartId;
        this.cartProducts = cartProducts;
        this.createdAt = LocalDateTime.now();
    }

    public static Cart init(String memberId) {
        return new Cart(memberId);
    }

    private List<CartProduct> makeEmptyCart() {
        return new ArrayList<>();
    }

    public void addProduct(CartProduct newProduct) {
        if (cartProducts.contains(newProduct)) {
            overwriteProduct(newProduct);
            return;
        }

        cartProducts.add(newProduct);
    }

    private void overwriteProduct(CartProduct newProduct) {
        CartProduct cartProduct = cartProducts.get(cartProducts.indexOf(newProduct));

        newProduct.plusCount(cartProduct.getCount());
        cartProducts.set(cartProducts.indexOf(newProduct), newProduct);
    }

    public Optional<CartProduct> findCartProductByProductCode(String productCode) {
        return cartProducts.stream()
                .filter(product -> product.getProductCode().equals(productCode))
                .findFirst();
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ",\n createdAt=" + createdAt.toString() +
                ",\n cartProducts=\n  " + cartProducts +
                '}';
    }
}
