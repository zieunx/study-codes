package study.spring.jpa.customer.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import study.spring.jpa.customer.domain.Customer;
import study.spring.jpa.subscription.domain.Subscription;
import study.spring.jpa.subscription.repository.SubscriptionRepository;

import javax.persistence.EntityNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@SpringBootTest
class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @BeforeEach
    void init() {
        customerService.createCustomer(
                new CreateCustomerRequest(
                        "회원1",
                        "010-1234-1234",
                        "국민 111-11111-111111",
                        "WEEK")
        );
        log.info("===init 끝===");
    }

    @Test
    void 저장() {

    }

    @Transactional
    @Test
    void 회원의_결제_삭제() {
        // when
        customerService.removePaymentMethod(1L, 1L);

        // then
        Customer customer = customerService.getCustomer(1L);
        Subscription subscription = subscriptionRepository.findById(1L)
                .orElseThrow(EntityNotFoundException::new);

        assertThat(customer.getPaymentMethods()).hasSize(0);
        assertThat(subscription.getPaymentMethod()).isNotNull();
        assertThat(subscription.getPaymentMethod().getCustomer()).isNull();
    }
}