package com.pairone.library.service;

import com.pairone.library.dto.member.request.MemberCreateRequestDto;
import com.pairone.library.dto.member.response.MemberCreateResponseDto;
import com.pairone.library.dto.member.response.MemberListDto;
import com.pairone.library.entity.Member;
import com.pairone.library.mapper.MemberMapper;
import com.pairone.library.repository.MemberRepository;
import com.pairone.library.rules.MemberBusinessRule;
import com.pairone.library.service.abstractservice.MemberService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;
    private final MemberBusinessRule memberBusinessRule;
    private final MemberMapper memberMapper;

    public MemberServiceImpl(MemberRepository memberRepository, MemberBusinessRule memberBusinessRule, MemberMapper memberMapper) {
        this.memberRepository = memberRepository;
        this.memberBusinessRule = memberBusinessRule;
        this.memberMapper = memberMapper;
    }

    public MemberCreateResponseDto addMember(MemberCreateRequestDto dto) {
        memberBusinessRule.memberShouldNotBePresent(dto.geteMail());
        Member member = memberMapper.memberCreateRequestDtoMapToEntity(dto);
        member = memberRepository.save(member);
        return memberMapper.entityMapToMemberCreateResponse(member);
    }

    public List<MemberListDto> getMembers() {
        List<Member> members = memberRepository.findAll();
        return members.stream().map(memberMapper::entityMapToListMember).toList();
    }

    public Member EntityMemberById(Integer id) {
        return memberRepository.findById(id).orElseThrow(() -> new RuntimeException("not found member by id"));
    }
}
