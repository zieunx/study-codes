package com.example.cache.service;

import com.example.cache.domain.Member;
import com.example.cache.repository.MemberRepository;
import com.example.cache.type.RankingType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


/*
* BasicRankingService
* -> 랭킹을 매기는 역할
* (BeginnerRankingService를 역할에 맞게 분리)
* */
@Service
public class BasicRankingService implements RankingService {
    private final Logger log = LoggerFactory.getLogger(getClass());
    private final MemberRepository memberRepository;

    public BasicRankingService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public List<Member> getRanking(RankingType type) {
        log.info("business logic execution");
        return this.memberRepository.findAll()
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
