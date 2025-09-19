package com.pairone.library.service;

import com.pairone.library.dto.member.request.MemberCreateRequestDto;
import com.pairone.library.dto.member.response.MemberCreateResponseDto;
import com.pairone.library.dto.member.response.MemberGetResponseDto;
import com.pairone.library.dto.member.response.MemberListDto;
import com.pairone.library.dto.member.response.PenaltyMemberGetResponseDto;
import com.pairone.library.dto.penalty.PagePenaltyRes;
import com.pairone.library.entity.Member;
import com.pairone.library.entity.Penalty;
import com.pairone.library.entity.enums.MembershipLevel;
import com.pairone.library.mapper.MemberMapper;
import com.pairone.library.mapper.PenaltyMapper;
import com.pairone.library.repository.MemberRepository;
import com.pairone.library.rules.MemberBusinessRule;
import com.pairone.library.service.abstractservice.MemberService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;
    private final MemberBusinessRule memberBusinessRule;
    private final MemberMapper memberMapper;
    private final PenaltyMapper penaltyMapper;

    public MemberServiceImpl(MemberRepository memberRepository, MemberBusinessRule memberBusinessRule, MemberMapper memberMapper, PenaltyMapper penaltyMapper) {
        this.memberRepository = memberRepository;
        this.memberBusinessRule = memberBusinessRule;
        this.memberMapper = memberMapper;
        this.penaltyMapper = penaltyMapper;
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

    public MemberGetResponseDto getMemberId(Integer id) {
        Member member = memberBusinessRule.findByMember(id);
        return memberMapper.entityMapToMemberGetResponseDto(member);
    }

    public Page<MemberGetResponseDto> filterQuery(String email, String status, int size, int page) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Member> members = memberRepository.filterQueryquery(email, status, pageable);
        return members.map(memberMapper::entityMapToMemberGetResponseDto);
    }

    @Override
    public void updateStatus(Integer id, MembershipLevel status) {
        Member member = memberBusinessRule.findByMember(id);
        member.setMembershipLevel(MembershipLevel.BANNED);
        memberRepository.save(member);
    }


}
