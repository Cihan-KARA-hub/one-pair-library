package com.pairone.library.service;

import com.pairone.library.dto.loan.*;
import com.pairone.library.entity.Book;
import com.pairone.library.entity.Loan;
import com.pairone.library.entity.Member;
import com.pairone.library.mapper.LoanMapper;
import com.pairone.library.repository.LoanRepository;
import com.pairone.library.rules.BookBusinessRule;
import com.pairone.library.rules.LoanBusinessRule;
import com.pairone.library.service.abstractservice.LoanService;
import com.pairone.library.service.abstractservice.MemberService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LoanServiceImpl implements LoanService {

    private final LoanRepository loanRepository;
    private final LoanBusinessRule loanBusinessRule;
    private final MemberService memberService;
    private final LoanMapper loanMapper;
    private final BookBusinessRule bookBusinessRule;

    public LoanServiceImpl(LoanRepository loanRepository, LoanBusinessRule loanBusinessRule,
                           MemberService memberService, LoanMapper loanMapper, BookBusinessRule bookBusinessRule) {
        this.loanRepository = loanRepository;
        this.loanBusinessRule = loanBusinessRule;
        this.memberService = memberService;
        this.loanMapper = loanMapper;
        this.bookBusinessRule = bookBusinessRule;
    }

    // --- Ödünç alma ---
    // üye sorgusu
    public LoanCreateResponseDto createLoan(LoanCreateDto dto) {
        Book book = bookBusinessRule.findBookIsExists(dto.getBookId());
        Member member = memberService.EntityMemberById(dto.getMemberId());
        // üye ödünç alma limit kontrolü
        loanBusinessRule.loanLimited(member);
        // Business rule kontrolü
        loanBusinessRule.validateLoanCreation(book.getId(), member.getId());

        Loan loan = loanMapper.toEntity(dto, book, member);

        // DueDate hesapla
        loan.setDueDate(loanBusinessRule.calculateDueDate(member, loan.getRequestDate()));

        loan.setStatus("BORROWED");
        Loan saved = loanRepository.save(loan);

        return new LoanCreateResponseDto(
                saved.getBook().getId(),
                saved.getMember().getFirstname(),
                saved.getId()
        );
    }

    // --- Loan iade ---
    public LoanResponseDto returnLoan(LoanReturnDto dto) {
        Loan loan = loanBusinessRule.findLoanIsExists(dto.getLoanId());
        loanBusinessRule.validateReturn(loan, dto.getReturnDate());
        Loan updated = loanRepository.save(loan);
        return LoanMapper.INSTANCE.toResponseDto(updated);
    }

    // --- Üye bazlı açık ödünçler ---
    public List<LoanListDto> getMemberLoans(Integer memberId, String status) {
        List<Loan> loans = loanRepository.findByMemberIdAndStatus(memberId, status);
        return loans.stream()
                .map(loanMapper::toListDto)
                .collect(Collectors.toList());
    }

    // --- Mevcut metodlar ---
    public List<LoanListDto> getAllLoans() {
        return loanRepository.findAll()
                .stream()
                .map(loanMapper::toListDto)
                .collect(Collectors.toList());
    }

    public LoanResponseDto getLoanById(int id) {
        Loan loan = loanBusinessRule.findLoanIsExists(id);
        return LoanMapper.INSTANCE.toResponseDto(loan);
    }

    public LoanResponseDto updateLoan(Integer id, LoanUpdateDto dto) {
        Loan loan = loanBusinessRule.findLoanIsExists(id);
        loanMapper.updateEntityFromDto(dto, loan);
        Loan updated = loanRepository.save(loan);
        return LoanMapper.INSTANCE.toResponseDto(updated);
    }

    public String deleteLoan(Integer id) {
        Loan loan = loanBusinessRule.findLoanIsExists(id);
        loanRepository.delete(loan);
        return "Loan Silindi: " + id;
    }

    public Loan entityLoanById(Integer id) {
        return loanBusinessRule.findLoanIsExists(id);
    }
}
