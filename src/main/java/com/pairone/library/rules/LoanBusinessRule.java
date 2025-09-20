package com.pairone.library.rules;

import com.pairone.library.dto.penalty.PenaltyCreateReq;
import com.pairone.library.entity.Book;
import com.pairone.library.entity.Loan;
import com.pairone.library.entity.Member;
import com.pairone.library.entity.enums.MembershipLevel;
import com.pairone.library.mapper.PenaltyMapper;
import com.pairone.library.repository.LoanRepository;
import com.pairone.library.service.PenaltyServiceImpl;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

@Component
public class LoanBusinessRule {

    private final LoanRepository loanRepository;
    private final BookBusinessRule bookBusinessRule;
    private final PenaltyBusinessRule penaltyBusinessRule;
    private final MemberBusinessRule memberBusinessRule;
    private final PenaltyServiceImpl penaltyService;
    private final PenaltyMapper penaltyMapper;


    public LoanBusinessRule(LoanRepository loanRepository,
                            BookBusinessRule bookBusinessRule,
                            @Lazy PenaltyBusinessRule penaltyBusinessRule,
                            MemberBusinessRule memberBusinessRule,
                            @Lazy PenaltyServiceImpl penaltyService,
                            PenaltyMapper penaltyMapper) {
        this.loanRepository = loanRepository;
        this.bookBusinessRule = bookBusinessRule;
        this.penaltyBusinessRule = penaltyBusinessRule;
        this.memberBusinessRule = memberBusinessRule;
        this.penaltyService = penaltyService;
        this.penaltyMapper = penaltyMapper;
    }

    //  Loan var mı kontrolü
    public Loan findLoanIsExists(Integer id) {
        return loanRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Loan bulunamadı: " + id));
    }

    //  Kitap mevcut mu ve ödünç verilebilir mi kontrolü
    public Book validateBookAvailability(Integer bookId) {
        Book book = bookBusinessRule.findBookIsExists(bookId);

        if (book.getAvailableCopies() <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Kitap ödünç verilemez. Mevcut kopya sayısı: " + book.getAvailableCopies());
        }

        return book;
    }

    //  Loan oluşturma kuralları (yeni kural member banned olamamlı )
    public Book validateLoanCreation(Integer bookId, Integer memberId) {
        validateMemberFineStatus(memberId);
        validateIsBanned(memberId);
        validateMemberDoesNotHaveSameBookLoaned(bookId, memberId);
        return validateBookAvailability(bookId);
    }

    // member engellenmiş mi ?
    private void validateIsBanned(Integer memberId) {
        boolean a = memberBusinessRule.isBanned(memberId);
        if (a) throw new RuntimeException("member banned");
    }

    private Member findMember(Integer memberId) {
        return memberBusinessRule.findByMember(memberId);
    }

    //  Üyenin borcu var mı kontrolü
    public void validateMemberFineStatus(Integer memberId) {
        penaltyBusinessRule.validateMemberHasNoUnpaidFines(memberId);
    }

    //  Aynı kitabı ikinci kez almaması kontrolü
    public void validateMemberDoesNotHaveSameBookLoaned(Integer bookId, Integer memberId) {
        boolean hasActiveBook = loanRepository.existsByBookIdAndMemberId(bookId, memberId);
        if (hasActiveBook) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Üye aynı kitabı zaten ödünç almış. İade etmeden tekrar alamaz.");
        }
    }

    // Üyenin üyelik tipine göre teslim tarihi hesaplama
    public OffsetDateTime calculateDueDate(Member member, OffsetDateTime loanDate) {
        int loanDays = getLoanDaysByMemberType(member);
        return loanDate.plusDays(loanDays);
    }

    // ödünç alma limit
    public void loanLimited(Member member) {
        List<Loan> loan = loanRepository.findByMember(member);
        if (member.getMembershipLevel().equals(MembershipLevel.GOLD) && loan.size() >= 5) {
            throw new RuntimeException("You have reached the maximum rental limit");

        } else if (member.getMembershipLevel().equals(MembershipLevel.STANDARD) && loan.size() >= 3) {
            throw new RuntimeException("You have reached the maximum rental limit");
        }

    }


    private int getLoanDaysByMemberType(Member member) {
        switch (member.getMembershipLevel()) {
            case STANDARD:
                return 14;
            case GOLD:
                return 21;
            default:
                return 14; // Default STANDARD
        }
    }

    public void validateReturn(Loan loan, OffsetDateTime returnDate) {
        checkAlreadyReturned(loan);
        checkLateReturnAndCreatePenalty(loan, returnDate);
        // İade bilgilerini güncelle
        loan.setStatus("RETURNED");
        loan.setReturnDate(returnDate);
        // Kitap kopya sayısını artır
        bookBusinessRule.incrementBook(loan.getBook().getId());
    }

    private void checkAlreadyReturned(Loan loan) {
        if ("RETURNED".equalsIgnoreCase(loan.getStatus())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Bu ödünç kaydı zaten iade edilmiş.");
        }
    }

    private void checkLateReturnAndCreatePenalty(Loan loan, OffsetDateTime returnDate) {
        if (returnDate.isAfter(loan.getDueDate())) {
            long daysLate = java.time.temporal.ChronoUnit.DAYS.between(
                    loan.getDueDate().toLocalDate(),
                    returnDate.toLocalDate()
            );
            Double fineAmount = (double) (daysLate * 5); // günlük 5₺
            createPenalty(loan.getId(), loan.getMember().getId(), fineAmount, daysLate);
        }
    }

    private void createPenalty(int loanId, Integer memberId, Double fineAmount, long daysLate) {
        PenaltyCreateReq req = new PenaltyCreateReq();
        req.setLoanId(loanId);
        req.setMemberId(memberId);
        req.setAmount(BigDecimal.valueOf(fineAmount));
        req.setPenaltyType("Late");
        req.setReturned(true);
        req.setDelayDays((int) daysLate);
        penaltyService.createPenalty(req);
    }


}
