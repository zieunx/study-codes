package com.example.multimodule.service;

import com.example.multimodule.domain.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceCustom {

    private final MemberRepository memberRepository;

    public MemberServiceCustom(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

}
