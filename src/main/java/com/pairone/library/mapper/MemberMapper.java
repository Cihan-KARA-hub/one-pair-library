package com.pairone.library.mapper;

import com.pairone.library.dto.member.request.MemberCreateRequestDto;
import com.pairone.library.dto.member.response.MemberCreateResponseDto;
import com.pairone.library.dto.member.response.MemberGetResponseDto;
import com.pairone.library.dto.member.response.MemberListDto;
import com.pairone.library.entity.Member;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MemberMapper {

    Member memberCreateRequestDtoMapToEntity(MemberCreateRequestDto responseDto);

    MemberCreateResponseDto entityMapToMemberCreateResponse(Member member);
    @Mapping(target = "addressId", source = "addressId", qualifiedByName = "mapAddress")
    @Mapping(target = "roleId", source = "roleId", qualifiedByName = "mapRole")
    MemberListDto entityMapToListMember(Member member);

    MemberGetResponseDto entityMapToMemberGetResponseDto(Member member);
}
