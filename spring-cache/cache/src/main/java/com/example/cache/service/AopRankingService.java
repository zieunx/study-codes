package com.example.cache.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.cache.annotation.Cacheable;
import com.example.cache.domain.Member;
import com.example.cache.repository.MemberRepository;
import com.example.cache.type.RankingType;

@Service
public class AopRankingService implements RankingService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	private final MemberRepository memberRepository;

	public AopRankingService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	@Cacheable(RANKING_GETTING_KEY)
	@Override
	public List<Member> getRanking(RankingType type) {
		log.info("business logic execution");
		return this.memberRepository.findAll()
			.stream()
			//              .sorted() 랭킹을 정하는 로직이 있다고 가정
			.collect(Collectors.toList());
	}
}
