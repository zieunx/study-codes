package com.test.java.javatest.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
public class SupplierService {

    public SupplierIssueTicketDto issueTicket(int i) throws InterruptedException {

        Thread.sleep(300);
        log.info("[{}\t] issueTicket() : {}", Thread.currentThread().getName(), i);

        return new SupplierIssueTicketDto("ticket-" + i, LocalDateTime.now());
    }
}
