package com.example.cache.service;

import com.example.cache.domain.Member;
import com.example.cache.type.RankingType;

import java.util.List;

public interface RankingService {

    // Redis에 저장할 prefix
    String RANKING_GETTING_KEY = "ranking:get";

    List<Member> getRanking(RankingType type);
}
