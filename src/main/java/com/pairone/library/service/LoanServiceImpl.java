package com.pairone.library.service;

import com.pairone.library.dto.loan.*;
import com.pairone.library.entity.Book;
import com.pairone.library.entity.Loan;
import com.pairone.library.entity.Member;
import com.pairone.library.mapper.LoanMapper;
import com.pairone.library.repository.BookRepository;
import com.pairone.library.repository.LoanRepository;
import com.pairone.library.repository.MemberRepository;
import com.pairone.library.service.abstractservice.LoanService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoanServiceImpl implements LoanService {

    private final LoanRepository loanRepository;
    private final BookRepository bookRepository;
    private final MemberRepository memberRepository;
    private final LoanMapper loanMapper;

    public LoanServiceImpl(LoanRepository loanRepository, BookRepository bookRepository,
                           MemberRepository memberRepository, LoanMapper loanMapper) {
        this.loanRepository = loanRepository;
        this.bookRepository = bookRepository;
        this.memberRepository = memberRepository;
        this.loanMapper = loanMapper;
    }

    public LoanCreateResponseDto createLoan(LoanCreateDto dto) {
        Book book = bookRepository.findById(dto.getBookId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book bulunamadı: " + dto.getBookId()));
        Member member = memberRepository.findById(dto.getMemberId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Member bulunamadı: " + dto.getMemberId()));

        Loan loan = loanMapper.toEntity(dto, book, member);
        Loan saved = loanRepository.save(loan);
        return new LoanCreateResponseDto(saved.getBook().getId(), saved.getMember().getFirstname(), saved.getId());
    }

    public List<LoanListDto> getAllLoans() {
        return loanRepository.findAll()
                .stream()
                .map(loanMapper::toListDto)
                .collect(Collectors.toList());
    }

    public LoanResponseDto getLoanById(int id) {
        Loan loan = loanRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Loan bulunamadı: " + id));
        return loanMapper.toResponseDto(loan);
    }

    public LoanResponseDto updateLoan(Integer id, LoanUpdateDto dto) {
        Loan loan = loanRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Loan bulunamadı: " + id));

        loanMapper.updateEntityFromDto(dto, loan);
        Loan updated = loanRepository.save(loan);
        return loanMapper.toResponseDto(updated);
    }

    public String deleteLoan(Integer id) {
        Loan loan = loanRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Loan bulunamadı: " + id));
        loanRepository.delete(loan);
        return "Loan Silindi: " + id;
    }

    public Loan entityLoanById(Integer id) {
        return loanRepository.findById(id).orElseThrow(() -> new RuntimeException(" not found loan"));
    }
}
