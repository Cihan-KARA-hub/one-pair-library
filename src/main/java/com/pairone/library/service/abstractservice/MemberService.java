package com.pairone.library.service.abstractservice;

import com.pairone.library.dto.member.request.MemberCreateRequestDto;
import com.pairone.library.dto.member.response.MemberCreateResponseDto;
import com.pairone.library.dto.member.response.MemberListDto;
import com.pairone.library.entity.Member;

import java.util.List;

public interface MemberService {
    Member EntityMemberById(Integer id);
    List<MemberListDto> getMembers();
    MemberCreateResponseDto addMember(MemberCreateRequestDto dto);
}
