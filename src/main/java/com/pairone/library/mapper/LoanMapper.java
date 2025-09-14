package com.pairone.library.mapper;

import com.pairone.library.dto.loan.LoanCreateDto;
import com.pairone.library.dto.loan.LoanListDto;
import com.pairone.library.dto.loan.LoanResponseDto;
import com.pairone.library.dto.loan.LoanUpdateDto;
import com.pairone.library.entity.Book;
import com.pairone.library.entity.Loan;
import com.pairone.library.entity.Member;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class LoanMapper {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_OFFSET_DATE_TIME;

    public static LoanResponseDto toResponseDto(Loan loan) {
        if (loan == null) return null;

        LoanResponseDto dto = new LoanResponseDto();
        dto.setId(loan.getId());
        dto.setBookId(loan.getBook().getId());
        dto.setBookTitle(loan.getBook().getName());
        dto.setMemberId(loan.getMember().getId());
        dto.setMemberName(loan.getMember().getFirstname());

        dto.setRequestDate(loan.getRequestDate() != null ? loan.getRequestDate().format(FORMATTER) : null);
        dto.setDueDate(loan.getDueDate() != null ? loan.getDueDate().format(FORMATTER) : null);
        dto.setReturnDate(loan.getReturnDate() != null ? loan.getReturnDate().format(FORMATTER) : null);

        dto.setStatus(loan.getStatus());
        return dto;
    }

    public Loan toEntity(LoanCreateDto dto, Book book, Member member) {
        if (dto == null) {
            return null;
        }
        Loan loan = new Loan();
        loan.setBook(book);
        loan.setMember(member);
        loan.setRequestDate(dto.getRequestDate());
        loan.setDueDate(dto.getDueDate());
        loan.setReturnDate(dto.getReturnDate());
        loan.setStatus(dto.getStatus());

        return loan;
    }

    public LoanListDto toListDto(Loan loan) {
        LoanListDto dto = new LoanListDto();

        dto.setId(loan.getId());
        dto.setBookTitle(loan.getBook().getBookinfoId().getTitle());
        dto.setMemberName(loan.getMember().getFirstname() + " " + loan.getMember().getLastname());
        dto.setRequestDate(loan.getRequestDate() != null ? loan.getRequestDate().format(FORMATTER) : null);
        dto.setDueDate(loan.getDueDate() != null ? loan.getDueDate().format(FORMATTER) : null);
        dto.setStatus(loan.getStatus());
        return dto;
    }


    public void updateEntityFromDto(LoanUpdateDto dto, Loan loan) {
        if (dto == null || loan == null) return;
        loan.setDueDate(OffsetDateTime.parse(dto.getDueDate(), FORMATTER));

        loan.setReturnDate(OffsetDateTime.parse(dto.getReturnDate(), FORMATTER));
        loan.setStatus(dto.getStatus());


    }
}
