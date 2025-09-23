package com.pairone.library.service;

import com.pairone.library.dto.member.request.MemberCreateRequestDto;
import com.pairone.library.dto.member.response.*;
import com.pairone.library.dto.penalty.PagePenaltyRes;
import com.pairone.library.entity.Address;
import com.pairone.library.entity.Member;
import com.pairone.library.entity.Penalty;
import com.pairone.library.entity.Role;
import com.pairone.library.entity.enums.MembershipLevel;
import com.pairone.library.mapper.MemberMapper;
import com.pairone.library.repository.MemberRepository;
import com.pairone.library.rules.AddressBusinessRules;
import com.pairone.library.rules.MemberBusinessRule;
import com.pairone.library.rules.PenaltyBusinessRule;
import com.pairone.library.rules.RoleBusinessRules;
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
    private final PenaltyBusinessRule penaltyBusinessRule;
    private final AddressBusinessRules addressBusinessRules;
    private final RoleBusinessRules roleBusinessRules;

    public MemberServiceImpl(MemberRepository memberRepository, MemberBusinessRule memberBusinessRule, MemberMapper memberMapper, PenaltyBusinessRule penaltyBusinessRule, AddressBusinessRules addressBusinessRules, RoleBusinessRules roleBusinessRules) {
        this.memberRepository = memberRepository;
        this.memberBusinessRule = memberBusinessRule;
        this.memberMapper = MemberMapper.INSTANCE;
        this.penaltyBusinessRule = penaltyBusinessRule;
        this.addressBusinessRules = addressBusinessRules;
        this.roleBusinessRules = roleBusinessRules;
    }

    public MemberCreateResponseDto addMember(MemberCreateRequestDto dto) {
        //role kontrolü ve address kayıt etme
        memberBusinessRule.memberShouldNotBePresent(dto.geteMail());
        Address address = addressBusinessRules.addressCreateRequestMapToEntity(dto.getAddress());
        Role role = roleBusinessRules.getRole(dto.getRole().getType());
        Member member = memberMapper.memberCreateRequestDtoMapToEntity(dto,address,role);
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
        member.setMembershipLevel(status);
        memberRepository.save(member);
    }


    public MemberGetPenaltyResponseDto getFinesIsPaid(Integer id, boolean isPaid) {
        Member member = memberBusinessRule.findByMember(id);
        List<Penalty> penalties = penaltyBusinessRule.memberIdIsPaid(member, isPaid);
        penaltyBusinessRule.pagePenaltyResMap(penalties);
        List<PagePenaltyRes> penaltiesRes = penaltyBusinessRule.pagePenaltyResMap(penalties);
        MemberGetResponseDto memDto = memberMapper.entityMapToMemberGetResponseDto(member);
        return new MemberGetPenaltyResponseDto(memDto, penaltiesRes);

    }

    public MemberActiveResponseDto setActive(Integer id, boolean activated) {
        Member member = memberBusinessRule.findByMember(id);
        member.setActive(activated);
        memberRepository.save(member);
        return new MemberActiveResponseDto(id.toString(), activated);
    }
}
