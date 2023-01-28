package com.study.spring.requestresponse;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("test")
@RestController
public class TestController {

    @PostMapping
    public ResponseEntity<?> requestPost(@RequestBody RequestTestDto requestDto) {
        log.info("requestDto: " + requestDto);

        return ResponseEntity.ok(new ResponseTestDto(HttpStatus.OK, "OK001"));
    }
}
