package com.pairone.library.mapper;

import com.pairone.library.dto.member.request.MemberCreateRequestDto;
import com.pairone.library.dto.member.response.MemberCreateResponseDto;
import com.pairone.library.dto.member.response.MemberListDto;
import com.pairone.library.entity.Member;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MemberMapper {

    Member memberCreateRequestDtoMapToEntity(MemberCreateRequestDto responseDto);
    MemberCreateResponseDto entityMapToMemberCreateResponse(Member member);
    MemberListDto entityMapToListMember(Member member);

}
