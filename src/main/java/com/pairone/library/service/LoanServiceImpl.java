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
import com.pairone.library.service.abstractservice.ReservationService;
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
    private final ReservationService reservationService;

    public LoanServiceImpl(LoanRepository loanRepository, LoanBusinessRule loanBusinessRule,
                           MemberService memberService, LoanMapper loanMapper, BookBusinessRule bookBusinessRule, ReservationService reservationService) {
        this.loanRepository = loanRepository;
        this.loanBusinessRule = loanBusinessRule;
        this.memberService = memberService;
        this.loanMapper = loanMapper;
        this.bookBusinessRule = bookBusinessRule;
        this.reservationService = reservationService;
    }

    // --- Ödünç alma ---
    // üye sorgusu
    public LoanCreateResponseDto createLoan(LoanCreateDto dto) {
        //Kitap var mı varsa stokta var mı ?
        Book book = bookBusinessRule.findBookIsExistsAndAvailableCopies(dto.getBookId());
        Member member = memberService.EntityMemberById(dto.getMemberId());
        // üye ödünç alma limit kontrolü
        loanBusinessRule.loanLimited(member);
        // Business rule kontrolü
        loanBusinessRule.validateLoanCreation(book.getId(), member.getId());
        Loan loan = loanMapper.toEntity(dto, book, member);
        // DueDate hesapla
        loan.setDueDate(loanBusinessRule.calculateDueDate(member, loan.getRequestDate()));
        loan.setStatus("BORROWED");
        bookBusinessRule.decreaseAvailableCopies(book.getId());
        Loan saved = loanRepository.save(loan);

        return new LoanCreateResponseDto(
                saved.getBook().getId(),
                saved.getMember().getFirstname(),
                saved.getId()
        );
    }

    // --- Loan iade ---//rezervasyon set
    public LoanResponseDto returnLoan(LoanReturnDto dto) {
        Loan loan = loanBusinessRule.findLoanIsExists(dto.getLoanId());
        // vaktinde getirmiş mi
        loanBusinessRule.validateReturn(loan, dto.getReturnDate());
        Loan updated = loanRepository.save(loan);
        bookBusinessRule.incrementBook(loan.getBook().getId());
        //rezervasyon sırası varsa harakete geçir kitap sorgusu at varmı rezerv.
        // varsa direk rezerve satatüsünü ve book statüsünü set et
        reservationService.trigger(loan.getBook());
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
