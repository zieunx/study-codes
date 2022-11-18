package com.study.springevent.domain.cart.domain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class CartRepository {
    public Cart findByUserId(String userId) {
        return new Cart(userId);
    }

    public void delete(Cart cart) {
        log.info("장바구니 삭제");
    }
}
