package com.study.spring.requestresponse;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
public class ResponseTestDto {
    private HttpStatus status;
    private String code;
}
