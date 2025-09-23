package com.pairone.library.mapper;

import com.pairone.library.dto.member.request.MemberCreateRequestDto;
import com.pairone.library.dto.member.response.MemberCreateResponseDto;
import com.pairone.library.dto.member.response.MemberGetResponseDto;
import com.pairone.library.dto.member.response.MemberListDto;
import com.pairone.library.entity.Address;
import com.pairone.library.entity.Member;
import com.pairone.library.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
@Mapper(componentModel = "spring")
public interface MemberMapper {
    MemberMapper INSTANCE = Mappers.getMapper(MemberMapper.class);

    @Mapping(target = "address", source = "address.id")
    @Mapping(target = "role", source = "role.roleId" )
    MemberListDto entityMapToListMember(Member member);
    @Mapping(target = "address", source = "address")
    @Mapping(target = "role", source = "role" )
    @Mapping(target = "id", ignore = true) // Member.id veritabanı tarafından oluşturulacak
    Member memberCreateRequestDtoMapToEntity(MemberCreateRequestDto dto, Address address, Role role);

    MemberCreateResponseDto entityMapToMemberCreateResponse(Member member);

    MemberGetResponseDto entityMapToMemberGetResponseDto(Member member);
}


