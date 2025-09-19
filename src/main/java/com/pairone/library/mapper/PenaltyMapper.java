package com.pairone.library.mapper;

import com.pairone.library.dto.member.response.PenaltyMemberGetResponseDto;
import com.pairone.library.dto.penalty.PagePenaltyRes;
import com.pairone.library.dto.penalty.PenaltyCreateReq;
import com.pairone.library.entity.Loan;
import com.pairone.library.entity.Member;
import com.pairone.library.entity.Penalty;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface PenaltyMapper {
    PenaltyMapper INSTANCE = Mappers.getMapper(PenaltyMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "amount", source = "req.amount")
    @Mapping(target = "delayDays", source = "req.delayDays")
    @Mapping(target = "returned", source = "req.returned")
    @Mapping(target = "penaltyType", source = "req.penaltyType")
    @Mapping(target = "member", source = "member")
    @Mapping(target = "loan", source = "loan")
    Penalty createToEntity(PenaltyCreateReq req, Loan loan, Member member);

    @Mapping(target = "id", source = "penalty.id")
    @Mapping(target = "memberId", source = "penalty.member.id")
    @Mapping(target = "loanId", source = "penalty.loan.id")
    @Mapping(target = "penaltyType", source = "penalty.penaltyType")
    @Mapping(target = "delayDays", source = "penalty.delayDays")
    @Mapping(target = "returned", source = "penalty.returned")
    @Mapping(target = "amount", source = "penalty.amount")
    PagePenaltyRes pageListDto(Penalty penalty);


    @Mapping(source = "member.id", target = "memberId")
    @Mapping(source = "member.eMail", target = "eMail")
    @Mapping(source = "member.firstname", target = "firstname")
    @Mapping(source = "member.lastname", target = "lastname")
    @Mapping(source = "member.phone", target = "phone")
    @Mapping(source = "loan.id", target = "loanId")
    @Mapping(source = "id", target = "id")
    @Mapping(source = "penaltyType", target = "penaltyType")
    @Mapping(source = "delayDays", target = "delayDays")
    @Mapping(source = "returned", target = "penalty.returned")
    @Mapping(source = "amount", target = "amount")
    PenaltyMemberGetResponseDto toPenaltyMemberGetResponse(Penalty penalty);
}