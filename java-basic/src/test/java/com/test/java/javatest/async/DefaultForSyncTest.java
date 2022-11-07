package com.test.java.javatest.async;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Slf4j
public class DefaultForSyncTest {

    @Autowired
    private SupplierService supplierService;

    @Test
    public void for문_동기() throws InterruptedException {
        log.info("test 시작");

        List<SupplierIssueTicketDto> supplierOrderConfirmGroup = new ArrayList<>();

        for (int i = 1; i <= 30; i++) {
            supplierOrderConfirmGroup.add(supplierService.issueTicket(i));
        }

        log.info("결과 > ");
        supplierOrderConfirmGroup.forEach((supplierOrderConfirm -> {
            log.info(supplierOrderConfirm.toString());
        }));

        log.info("test 종료");
    }
}
