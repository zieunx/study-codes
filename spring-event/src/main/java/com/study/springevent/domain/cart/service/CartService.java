package com.study.springevent.domain.cart.service;

import com.study.springevent.domain.cart.domain.Cart;
import com.study.springevent.domain.cart.domain.CartRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RequiredArgsConstructor
@Service
public class CartService {
    private final CartRepository cartRepository;

    @Transactional
    public void deleteCart(String userId) {
        Cart cart = cartRepository.findByUserId(userId);
        cartRepository.delete(cart);
    }
}
