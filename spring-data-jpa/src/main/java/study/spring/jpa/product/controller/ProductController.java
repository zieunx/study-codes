package study.spring.jpa.product.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.spring.jpa.product.dto.RequestOrderProduct;
import study.spring.jpa.product.service.OrderProductService;

@RequiredArgsConstructor
@RequestMapping("/product")
@RestController
public class ProductController {

    private final OrderProductService orderProductService;

    @PostMapping("/order")
    public ResponseEntity<?> requestOrderProduct(@RequestBody RequestOrderProduct request) {
        orderProductService.orderProduct(request);

        return ResponseEntity.ok("성공");
    }
}
