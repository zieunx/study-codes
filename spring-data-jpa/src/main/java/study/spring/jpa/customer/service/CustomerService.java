package study.spring.jpa.customer.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.spring.jpa.customer.domain.Customer;
import study.spring.jpa.customer.domain.PaymentMethod;
import study.spring.jpa.customer.repository.CustomerRepository;
import study.spring.jpa.subscription.domain.Subscription;

import javax.persistence.EntityExistsException;
import java.util.Collections;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Transactional
    public Customer createCustomer(CreateCustomerRequest dto) {
        Subscription subscription = new Subscription(dto.getSubscriptionType());
        PaymentMethod paymentMethod = new PaymentMethod(dto.getCardNumber());

        Customer customer = customerRepository.save(
                new Customer(
                        dto.getName(),
                        dto.getPhone(),
                        Collections.singletonList(subscription),
                        Collections.singletonList(paymentMethod)
                )
        );

        return customer;
    }

    @Transactional
    public void removePaymentMethod(long customerId, long paymentMethodId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(EntityExistsException::new);

        customer.removePaymentMethod(paymentMethodId);
    }
}
