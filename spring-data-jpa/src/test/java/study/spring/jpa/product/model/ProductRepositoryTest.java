package study.spring.jpa.product.model;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import study.spring.jpa.product.model.Product;
import study.spring.jpa.product.model.ProductRepository;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@Slf4j
@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void annotationBasicOptionalFalse() {
        // when
        assertThatThrownBy(() -> productRepository.save(new Product(
                null,
                3000,
                "설명",
                UUID.randomUUID()
        ))).isInstanceOf(DataIntegrityViolationException.class);
    }

}