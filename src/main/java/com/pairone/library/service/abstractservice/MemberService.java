package com.pairone.library.service.abstractservice;

import com.pairone.library.dto.member.request.MemberCreateRequestDto;
import com.pairone.library.dto.member.response.MemberCreateResponseDto;
import com.pairone.library.dto.member.response.MemberGetResponseDto;
import com.pairone.library.dto.member.response.MemberListDto;
import com.pairone.library.dto.member.response.PenaltyMemberGetResponseDto;
import com.pairone.library.entity.Member;
import com.pairone.library.entity.enums.MembershipLevel;
import org.springframework.data.domain.Page;

import java.util.List;

public interface MemberService {
    Member EntityMemberById(Integer id);
    List<MemberListDto> getMembers();
    MemberCreateResponseDto addMember(MemberCreateRequestDto dto);
    MemberGetResponseDto getMemberId(Integer id);
    Page<MemberGetResponseDto> filterQuery(String email, String status, int size, int page);

    void updateStatus(Integer id, MembershipLevel status);

}
