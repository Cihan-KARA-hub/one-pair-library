package com.pairone.library.service.abstractservice;

import com.pairone.library.dto.member.MemberCreateDto;
import com.pairone.library.dto.member.MemberListDto;
import com.pairone.library.entity.Member;

import java.util.List;

public interface MemberService {
    Member EntityMemberById(Integer id);
    List<MemberListDto> getMembers();
    void addMember(MemberCreateDto dto);
}
