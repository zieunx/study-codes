package study.spring.jpa.product.service;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.spring.jpa.product.dto.RequestOrderProduct;
import study.spring.jpa.product.model.OrderProductEvent;
import study.spring.jpa.product.model.Product;
import study.spring.jpa.product.model.ProductRepository;

import javax.persistence.EntityNotFoundException;

@RequiredArgsConstructor
@Service
public class OrderProductService {

    private final ProductRepository productRepository;
    private final ApplicationEventPublisher eventPublisher;

    @Transactional
    public void orderProduct(RequestOrderProduct request) {
        Product product = productRepository.findByIdForUpdate(request.getProductId())
                .orElseThrow(() -> new EntityNotFoundException("상품을 찾을 수 없습니다."));

        product.minusStock();

        eventPublisher.publishEvent(new OrderProductEvent(request));
    }
}
