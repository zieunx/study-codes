package study.spring.jpa.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.spring.jpa.customer.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
