package study.spring.jpa.product.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import study.spring.jpa.product.dto.RequestOrderProduct;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@SpringBootTest
class OrderProductServiceTest {

    @Autowired
    private OrderProductService orderProductService;

    private static final List<String> users = new ArrayList<>();

    static {
        for (int i = 1; i <= 101; i++) {
            users.add("사용자" + i);
        }
    }

    @Test
    void parallelStream은_병렬이라_순서보장되지_않는다() {
        users.parallelStream()
                .forEach(name -> log.info("{}", name));
    }

    @Test
    void 상품재고_테스트() {
        users.parallelStream()
                .forEach(name -> orderProductService.orderProduct(new RequestOrderProduct(name, "번호", 1L)));
    }
}