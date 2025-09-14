package com.pairone.library.mapper;

import com.pairone.library.dto.penalty.PagePenaltyRes;
import com.pairone.library.dto.penalty.PenaltyCreateReq;
import com.pairone.library.entity.Loan;
import com.pairone.library.entity.Member;
import com.pairone.library.entity.Penalty;
import org.springframework.stereotype.Component;

@Component
public class PenaltyMapper {

    public Penalty createToEntity(PenaltyCreateReq req, Loan loan, Member member) {
        Penalty penalty = new Penalty();
        penalty.setAmount(req.getAmount());
        penalty.setDelayDays(req.getDelayDays());
        penalty.setReturned(req.isReturned());
        penalty.setPenaltyType(req.getPenaltyType());
        penalty.setMember(member);
        penalty.setLoan(loan);
        return penalty;
    }

    public PagePenaltyRes pageListDto(Penalty penalty) {
        return new PagePenaltyRes(penalty.getId(),
                penalty.getMember().getId(),
                penalty.getMember().getId(),
                penalty.getPenaltyType(),
                penalty.getDelayDays(),
                penalty.isReturned(),
                penalty.getAmount());
    }
}
