package com.study.spring.di.cycle;

import org.springframework.stereotype.Service;

@Service
public class CycleBService {
    private CycleAService cycleAService;

    public CycleBService(CycleAService cycleAService) {
        this.cycleAService = cycleAService;
    }
}
