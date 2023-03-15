package study.spring.jpa.subscription.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import study.spring.jpa.customer.domain.Customer;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "subscription")
public class Subscription {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String generateType;

    @CreatedDate
    private LocalDateTime createdAt;

    public Subscription(String generateType) {
        this.generateType = generateType;
    }
}
