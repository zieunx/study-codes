package study.spring.jpa.customer.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.spring.jpa.customer.domain.Customer;
import study.spring.jpa.customer.domain.PaymentMethod;
import study.spring.jpa.customer.repository.CustomerRepository;
import study.spring.jpa.subscription.domain.Subscription;
import study.spring.jpa.subscription.repository.SubscriptionRepository;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.Collections;

@Slf4j
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final SubscriptionRepository subscriptionRepository;

    public CustomerService(CustomerRepository customerRepository, SubscriptionRepository subscriptionRepository) {
        this.customerRepository = customerRepository;
        this.subscriptionRepository = subscriptionRepository;
    }

    @Transactional
    public Customer createCustomer(CreateCustomerRequest dto) {
        Customer customer = new Customer(
                dto.getName(),
                dto.getPhone()
        );
        customerRepository.save(customer);

        PaymentMethod paymentMethod = new PaymentMethod(dto.getCardNumber(), customer);
        Subscription subscription = new Subscription(dto.getSubscriptionType(), customer, paymentMethod);
        customer.addPaymentMethod(paymentMethod);
        customer.addSubscription(subscription);

        subscriptionRepository.save(subscription);

        return customer;
    }

    @Transactional
    public void removePaymentMethod(long customerId, long paymentMethodId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(EntityExistsException::new);

        customer.removePaymentMethod(paymentMethodId);
    }

    @Transactional(readOnly = true)
    public Customer getCustomer(long id) {
        return customerRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }
}
