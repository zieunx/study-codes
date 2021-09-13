package com.example.cache.service;

import com.example.cache.domain.Member;
import com.example.cache.repository.MemberRepository;
import com.example.cache.type.RankingType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static java.lang.String.format;

@Service
public class BeginnerRankingService implements RankingService {
    private final Logger log = LoggerFactory.getLogger(getClass());
    private final MemberRepository memberRepository;
    private ValueOperations<String, List<Member>> operations;

    public BeginnerRankingService(MemberRepository memberRepository, RedisTemplate redisTemplate) {
        this.memberRepository = memberRepository;
        this.operations = redisTemplate.opsForValue();
    }

    @Override
    public List<Member> getRanking(RankingType type) {
        final String key = format("%s:%s", RANKING_GETTING_KEY, type.name().toLowerCase());
        final List<Member> cachedRankingList = this.operations.get(key);

        if (!CollectionUtils.isEmpty(cachedRankingList)) {
            return cachedRankingList;
        }

        log.info("business logic execution");
        final List<Member> rankingList = this.memberRepository.findAll()
                .stream()
                .sorted()
                .collect(Collectors.toList());

        this.operations.set(key, rankingList, 30L, TimeUnit.SECONDS);
        return rankingList;
    }
}
