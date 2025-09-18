package com.pairone.library.rules;

import com.pairone.library.entity.Book;
import com.pairone.library.entity.Loan;
import com.pairone.library.entity.Member;
import com.pairone.library.repository.LoanRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;

@Component
public class LoanBusinessRule {

    private final LoanRepository loanRepository;
    private final BookBusinessRule bookBusinessRule;
    private final PenaltyBusinessRule penaltyBusinessRule;

    public LoanBusinessRule(LoanRepository loanRepository, BookBusinessRule bookBusinessRule, PenaltyBusinessRule penaltyBusinessRule) {
        this.loanRepository = loanRepository;
        this.bookBusinessRule = bookBusinessRule;
        this.penaltyBusinessRule = penaltyBusinessRule;
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

    //  Loan oluşturma kuralları
    public Book validateLoanCreation(Integer bookId, Integer memberId) {
        validateMemberFineStatus(memberId);
        validateMemberDoesNotHaveSameBookLoaned(bookId, memberId);
        return validateBookAvailability(bookId);
    }

    //  Üyenin borcu var mı kontrolü
    public void validateMemberFineStatus(Integer memberId) {
        penaltyBusinessRule.validateMemberHasNoUnpaidFines(memberId);
    }

    //  Aynı kitabı ikinci kez almaması kontrolü
    public void validateMemberDoesNotHaveSameBookLoaned(Integer bookId, Integer memberId) {
        boolean hasActiveBook = loanRepository.existsByBookIdAndMemberIdAndIsReturnedFalse(bookId, memberId);
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
        // Daha önce iade edilmiş mi?
        if ("RETURNED".equalsIgnoreCase(loan.getStatus())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Bu ödünç kaydı zaten iade edilmiş.");
        }

        // Gecikme kontrolü
        if (returnDate.isAfter(loan.getDueDate())) {
            long daysLate = java.time.temporal.ChronoUnit.DAYS.between(
                    loan.getDueDate().toLocalDate(),
                    returnDate.toLocalDate()
            );
            int fineAmount = (int) (daysLate * 5); // günlük 5₺
            penaltyBusinessRule.createLatePenalty(loan.getId(), loan.getMember().getId(), fineAmount);
        }

        // İade bilgilerini güncelle
        loan.setStatus("RETURNED");
        loan.setReturnDate(returnDate);

        // Kitap kopya sayısını artır
        Book book = loan.getBook();
        book.setAvailableCopies(book.getAvailableCopies() + 1);
    }

}
