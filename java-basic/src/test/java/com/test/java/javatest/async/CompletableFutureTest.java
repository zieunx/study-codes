package com.test.java.javatest.async;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@SpringBootTest
@Slf4j
public class CompletableFutureTest {
    @Autowired
    private SupplierService supplierService;

    @Test
    public void CompletableFuture를_이용햔_비동기() {
        log.info("test 시작");

        List<CompletableFuture<SupplierIssueTicketDto>> supplierOrderConfirmFutures = new ArrayList<>();
        for (int i = 1; i <= 30; i++) {
            int finalI = i;
            supplierOrderConfirmFutures.add(CompletableFuture.supplyAsync(() -> {
                try {
                    return supplierService.issueTicket(finalI);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }));
        }

        List<SupplierIssueTicketDto> supplierOrderConfirmGroup = supplierOrderConfirmFutures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());

        log.info("결과 > ");
        supplierOrderConfirmGroup.forEach((supplierOrderConfirm -> {
            log.info("[{}\t] {}", Thread.currentThread().getName(), supplierOrderConfirm.toString());
        }));

        log.info("test 종료");
    }
}
