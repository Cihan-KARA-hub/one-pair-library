package com.pairone.library.rules;

import com.pairone.library.dto.penalty.PagePenaltyRes;
import com.pairone.library.entity.Member;
import com.pairone.library.entity.Penalty;
import com.pairone.library.mapper.PenaltyMapper;
import com.pairone.library.repository.PenaltyRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Component
public class PenaltyBusinessRule {
    private final PenaltyRepository penaltyRepository;
    private final PenaltyMapper penaltyMapper;

    public PenaltyBusinessRule(PenaltyRepository penaltyRepository1, PenaltyMapper penaltyMapper) {

        this.penaltyRepository = penaltyRepository1;
        this.penaltyMapper = penaltyMapper;
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

    public List<Penalty> memberIdIsPaid(Member member, boolean isPaid) {
        List<Penalty> penalties = new ArrayList<>();
        member.getPenalties().stream().map(penalty -> {
            if (isPaid == penalty.isReturned()) ;
            {
                penalties.add(penalty);
            }
            return penalty;
        });
        return penalties;
    }

    public List<PagePenaltyRes> pagePenaltyResMap(List<Penalty> penalties) {
        return penalties.stream().map(penaltyMapper::pageListDto).toList();
    }
}