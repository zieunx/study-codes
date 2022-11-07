package study.redis.domain.order.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import study.redis.domain.order.domain.Cart;
import study.redis.domain.order.domain.CartProduct;
import study.redis.domain.order.domain.CartRepository;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class CartService {
    private final CartRepository cartRepository;

    public void addToCart(String memberId, List<CartProduct> newCartProducts) {
        Cart cart = cartRepository.findById(memberId)
                .orElseGet(() -> Cart.init(memberId));

        newCartProducts.forEach(cart::addProduct);

        log.info("addToCart 결과: {}", cart);
    }

    public Cart findCartOrGetInit(String memberId) {
        return cartRepository.findById(memberId)
                .orElseGet(() -> Cart.init(memberId));
    }
}
