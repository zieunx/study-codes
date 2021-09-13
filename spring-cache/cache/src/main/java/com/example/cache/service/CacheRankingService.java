package com.example.cache.service;

import com.example.cache.domain.Member;
import com.example.cache.type.RankingType;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.String.format;


/*
 * CacheRankingService
 * -> Cache 기능을 구현한 랭킹 서비스
 * (BeginnerRankingService를 역할에 맞게 분리)
 * */
@Service
public class CacheRankingService implements RankingService {
    private final RankingService rankingService;
    private ValueOperations<String, List<Member>> operations;

    public CacheRankingService(RedisTemplate redisTemplate, RankingService basicRankingService) {
        this.operations = redisTemplate.opsForValue();
        this.rankingService = basicRankingService;
    }

    @Override
    public List<Member> getRanking(RankingType type) {
        final String key = format("%s:%s", RANKING_GETTING_KEY, type.name().toLowerCase());
        final List<Member> cachedRankingList = this.operations.get(key);

        if (!CollectionUtils.isEmpty(cachedRankingList)) {
            return cachedRankingList;
        }

        final List<Member> rankingList = this.rankingService.getRanking(type);
        this.operations.set(key, rankingList, 30L, TimeUnit.SECONDS);
        return rankingList;
    }
}
