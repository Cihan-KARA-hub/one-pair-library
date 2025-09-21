package com.pairone.library.rules;

import com.pairone.library.core.exception.type.BusinessException;
import com.pairone.library.entity.Member;
import com.pairone.library.entity.Penalty;
import com.pairone.library.entity.enums.MembershipLevel;
import com.pairone.library.repository.MemberRepository;
import org.springframework.stereotype.Component;

@Component
public class MemberBusinessRule {
    private final MemberRepository memberRepository;

    public MemberBusinessRule(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void memberShouldNotBePresent(String email) {
        Member member = memberRepository.findByemail(email);
        if (member != null) {
            throw new BusinessException("already such a member ");
        }
    }

    public boolean isBanned(Integer memberId) {
        return memberRepository.existsByIdAndMembershipLevel(memberId, MembershipLevel.BANNED);
    }

    public Member findByMember(Integer memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(() -> new BusinessException("member not found"));

    }

}
