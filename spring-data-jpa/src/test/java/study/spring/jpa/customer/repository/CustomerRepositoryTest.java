package study.spring.jpa.customer.repository;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import study.spring.jpa.customer.domain.Customer;
import study.spring.jpa.customer.domain.PaymentMethod;
import study.spring.jpa.subscription.domain.Subscription;
import study.spring.jpa.support.DataJpaTestSupport;

import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
public class CustomerRepositoryTest extends DataJpaTestSupport {

    private final CustomerRepository customerRepository;

    public CustomerRepositoryTest(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Test
    void 결제수단_삭제시_연결데이터가_있으면_에러발생1() {
        Customer customer = save(
                new Customer(
                        "홍길동",
                        "010-1234-1111"
                )
        );
        PaymentMethod paymentMethod = new PaymentMethod(
                "신한 111-1111-11111",
                customer
        );
        save(
                new Subscription(
                        "WEEK",
                        customer,
                        paymentMethod
                )
        );
        log.info("=== 초기화 끝 ===");
        Long customerId = customer.getId();
        Long paymentMethodId = paymentMethod.getId();

        // when
        Customer findCustomer = customerRepository.findById(customerId)
                .orElseThrow(EntityNotFoundException::new);

        assertThatThrownBy(() -> {
            findCustomer.removePaymentMethod(paymentMethodId);
            flushAndClearPersistentContext();
        }).isInstanceOf(PersistenceException.class);
        // TODO: 원인파악해보기 - ConstraintViolationException 발생했지만 스프링이 PersistenceException 로 던져진다.
    }
}
