package com.pairone.library.rules;
import com.pairone.library.entity.Penalty;
import com.pairone.library.repository.PenaltyRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Component
public class PenaltyBusinessRule {
    private final PenaltyRepository penaltyRepository;

    public PenaltyBusinessRule(PenaltyRepository penaltyRepository) {
        this.penaltyRepository = penaltyRepository;
    }

    public Penalty findPenaltyIsExists(Integer id) {
        return penaltyRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Penalty bulunamadı: " + id));
    }

    public void checkDuplicatePenalty(Integer loanId, Integer memberId, String penaltyType) {
        boolean exists = penaltyRepository.existsByLoanIdAndMemberIdAndPenaltyType(
                loanId, memberId, penaltyType);
        if (exists) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Bu loan ve member için aynı tipte ceza zaten var");
        }
    }

    public void validateMemberHasNoUnpaidFines(Integer memberId) {
        List<Penalty> allPenalties = penaltyRepository.findAll();
        boolean hasUnpaidFines = allPenalties.stream()
                .anyMatch(penalty -> penalty.getMember().getId().equals(memberId) && !penalty.isReturned());
        if (hasUnpaidFines) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Üyenin ödenmemiş cezası bulunmaktadır. Yeni ödünç alamaz.");
        }
    }



}