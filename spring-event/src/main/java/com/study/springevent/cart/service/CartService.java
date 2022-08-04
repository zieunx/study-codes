package com.study.springevent.cart.service;

import com.study.springevent.cart.domain.Cart;
import com.study.springevent.cart.domain.CartRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class CartService {
    private final CartRepository cartRepository;

    public void deleteCart(String userId) {
        Cart cart = cartRepository.findByUserId(userId);
        cartRepository.delete(cart);
    }
}
