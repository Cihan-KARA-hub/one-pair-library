package com.pairone.library.rules;

import com.pairone.library.repository.MemberRepository;
import org.springframework.stereotype.Component;

@Component
public class MemberBusinessRule {
    private final MemberRepository memberRepository;

    public MemberBusinessRule(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
}
