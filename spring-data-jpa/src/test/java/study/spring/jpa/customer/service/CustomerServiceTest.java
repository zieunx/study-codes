package study.spring.jpa.customer.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;

    @Test
    void 회원_저장() {
        customerService.createCustomer(new CreateCustomerRequest("회원1", "010-1234-1234"));
    }
}