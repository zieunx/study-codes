package com.study.springevent.order.domain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class OrderRepository {

    public Order save(Order order) {
        log.info("주문 데이터 저장");
        return order;
    }
}
