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

@Mapper(componentModel = "spring")
public interface MemberMapper {

    Member memberCreateRequestDtoMapToEntity(MemberCreateRequestDto responseDto);

    MemberCreateResponseDto entityMapToMemberCreateResponse(Member member);
    @Mapping(target = "addressId", source = "addressId", qualifiedByName = "mapAddress")
    @Mapping(target = "roleId", source = "roleId", qualifiedByName = "mapRole")
    MemberListDto entityMapToListMember(Member member);

    // Address -> Integer id
    @Named("mapAddress")
    default Integer mapAddress(Address address) {
        return (address != null) ? address.getId() : null;
    }

    // Role -> Integer id
    @Named("mapRole")
    default Integer mapRole(Role role) {
        return (role != null) ? role.getRoleId() : null;
    }

    MemberGetResponseDto entityMapToMemberGetResponseDto(Member member);
}
