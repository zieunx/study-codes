package com.test.java.javatest.async;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SupplierIssueTicketDto {
    private String ticketNumber;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime orderDateTime;

    public SupplierIssueTicketDto(String ticketNumber, LocalDateTime orderDateTime) {
        this.ticketNumber = ticketNumber;
        this.orderDateTime = orderDateTime;
    }
}
