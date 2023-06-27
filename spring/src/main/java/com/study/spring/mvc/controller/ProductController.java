package com.study.spring.mvc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/product")
public class ProductController {

    @GetMapping
    public void requestProduct(
            Pageable page,
            RequestDto dto
    ) {
        log.info("page={}", page);
        log.info("page={}", dto);
    }
}
