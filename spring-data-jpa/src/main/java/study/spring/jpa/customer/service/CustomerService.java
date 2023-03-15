package study.spring.jpa.customer.service;

import org.springframework.stereotype.Service;
import study.spring.jpa.customer.domain.Customer;
import study.spring.jpa.customer.repository.CustomerRepository;
import study.spring.jpa.subscription.domain.Subscription;

import java.util.Collections;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer createCustomer(CreateCustomerRequest dto) {
        Subscription subscription = new Subscription("WEEK");

        Customer customer = customerRepository.save(
                new Customer(
                        dto.getName(),
                        dto.getPhone(),
                        Collections.singletonList(subscription)
                )
        );

        return customer;
    }
}
