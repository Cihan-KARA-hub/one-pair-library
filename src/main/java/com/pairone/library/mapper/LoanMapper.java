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
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

@Mapper(componentModel = "spring")
public interface LoanMapper {

    LoanMapper INSTANCE = Mappers.getMapper(LoanMapper.class);

    DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    // DTO -> Entity
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "book", source = "book")
    @Mapping(target = "member", source = "member")
    @Mapping(target = "requestDate", source = "dto.requestDate", qualifiedByName = "stringToOffsetDateTime")
    @Mapping(target = "dueDate", source = "dto.dueDate", qualifiedByName = "stringToOffsetDateTime")
    @Mapping(target = "returnDate", source = "dto.returnDate", qualifiedByName = "stringToOffsetDateTime")
    @Mapping(target = "status", source = "dto.status")
    Loan toEntity(LoanCreateDto dto, Book book, Member member);

    // Entity -> DTO
    @Mapping(target = "id", source = "loan.id")
    @Mapping(target = "bookTitle", source = "loan.book.bookinfoId.title")
    @Mapping(target = "memberName", expression = "java(loan.getMember().getFirstname() + \" \" + loan.getMember().getLastname())")
    @Mapping(target = "requestDate", source = "loan.requestDate", qualifiedByName = "offsetDateTimeToString")
    @Mapping(target = "dueDate", source = "loan.dueDate", qualifiedByName = "offsetDateTimeToString")
    @Mapping(target = "returnDate", source = "loan.returnDate", qualifiedByName = "offsetDateTimeToString")
    @Mapping(target = "status", source = "loan.status")
    LoanResponseDto toResponseDto(Loan loan);

    @Mapping(target = "id", source = "loan.id")
    @Mapping(target = "bookTitle", source = "loan.book.bookinfoId.title")
    @Mapping(target = "memberName", expression = "java(loan.getMember().getFirstname() + \" \" + loan.getMember().getLastname())")
    @Mapping(target = "requestDate", source = "loan.requestDate", qualifiedByName = "offsetDateTimeToString")
    @Mapping(target = "dueDate", source = "loan.dueDate", qualifiedByName = "offsetDateTimeToString")
    @Mapping(target = "status", source = "loan.status")
    LoanListDto toListDto(Loan loan);

    // DTO -> Entity güncelleme
    @Mapping(target = "book", ignore = true)
    @Mapping(target = "member", ignore = true)
    @Mapping(target = "requestDate", ignore = true)
    @Mapping(target = "dueDate", source = "dto.dueDate", qualifiedByName = "stringToOffsetDateTime")
    @Mapping(target = "returnDate", source = "dto.returnDate", qualifiedByName = "stringToOffsetDateTime")
    @Mapping(target = "status", source = "dto.status")
    void updateEntityFromDto(LoanUpdateDto dto, @MappingTarget Loan loan);

    // Helper methods
    default String offsetDateTimeToString(OffsetDateTime dateTime) {
        return dateTime != null ? dateTime.format(FORMATTER) : null;
    }

    default OffsetDateTime stringToOffsetDateTime(String date) {
        return date != null && !date.isBlank() ? OffsetDateTime.parse(date + "T00:00:00+00:00") : null;
    }
}
