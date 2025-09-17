package com.pairone.library.mapper;

import com.pairone.library.dto.loan.LoanCreateDto;
import com.pairone.library.dto.loan.LoanListDto;
import com.pairone.library.dto.loan.LoanResponseDto;
import com.pairone.library.dto.loan.LoanUpdateDto;
import com.pairone.library.entity.Book;
import com.pairone.library.entity.Loan;
import com.pairone.library.entity.Member;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

@Mapper(componentModel = "spring")
public interface LoanMapper {
    LoanMapper INSTANCE = Mappers.getMapper(LoanMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "book", source = "book")
    @Mapping(target = "member", source = "member")
    @Mapping(target = "requestDate", source = "dto.requestDate")
    @Mapping(target = "dueDate", source = "dto.dueDate")
    @Mapping(target = "returnDate", source = "dto.returnDate")
    @Mapping(target = "status", source = "dto.status")
    Loan toEntity(LoanCreateDto dto, Book book, Member member);
    @Mapping(target = "id", source = "loan.id")
    @Mapping(target = "bookId", source = "loan.book.id")
    @Mapping(target = "bookTitle", source = "loan.book.name")
    @Mapping(target = "memberId", source = "loan.member.id")
    @Mapping(target = "memberName", source = "loan.member.firstname")
    @Mapping(target = "requestDate", source = "loan.requestDate", dateFormat = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    @Mapping(target = "dueDate", source = "loan.dueDate", dateFormat = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    @Mapping(target = "returnDate", source = "loan.returnDate", dateFormat = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    @Mapping(target = "status", source = "loan.status")
    LoanResponseDto toResponseDto(Loan loan);

    @Mapping(target = "id", source = "loan.id")
    @Mapping(target = "bookTitle", source = "loan.book.bookinfoId.title")
    @Mapping(target = "memberName", expression = "java(loan.getMember().getFirstname() + \" \" + loan.getMember().getLastname())")
    @Mapping(target = "requestDate", source = "loan.requestDate", dateFormat = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    @Mapping(target = "dueDate", source = "loan.dueDate", dateFormat = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    @Mapping(target = "status", source = "loan.status")
    LoanListDto toListDto(Loan loan);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "book", ignore = true)
    @Mapping(target = "member", ignore = true)
    @Mapping(target = "requestDate", ignore = true)
    @Mapping(target = "dueDate", source = "dto.dueDate", dateFormat = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    @Mapping(target = "returnDate", source = "dto.returnDate", dateFormat = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    @Mapping(target = "status", source = "dto.status")
    void updateEntityFromDto(LoanUpdateDto dto, @MappingTarget Loan loan);
}