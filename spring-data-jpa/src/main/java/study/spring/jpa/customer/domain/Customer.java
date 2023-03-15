package study.spring.jpa.customer.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import study.spring.jpa.subscription.domain.Subscription;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "customer")
public class Customer {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String name;

    private String phone;

    @OneToMany(mappedBy = "customer")
    private List<Subscription> subscriptions;

    public Customer(String name, String phone, List<Subscription> subscriptions) {
        this.name = name;
        this.phone = phone;
        this.subscriptions = subscriptions;
    }
}
