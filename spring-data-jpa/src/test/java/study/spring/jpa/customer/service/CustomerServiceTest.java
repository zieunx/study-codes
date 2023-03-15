package study.spring.jpa.customer.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;

    @BeforeEach
    void init() {
        customerService.createCustomer(
                new CreateCustomerRequest(
                        "회원1",
                        "010-1234-1234",
                        "국민 111-11111-111111",
                        "WEEK")
        );
    }

    @Test
    void 회원의_결제_삭제() {
        customerService.removePaymentMethod(1L, 1L);
    }
}