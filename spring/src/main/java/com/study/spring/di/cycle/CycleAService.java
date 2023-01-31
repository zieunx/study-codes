package com.study.spring.di.cycle;

import org.springframework.stereotype.Service;

//@Service
public class CycleAService {
    private CycleBService cycleBService;

    public CycleAService(CycleBService cycleBService) {
        this.cycleBService = cycleBService;
    }
}
