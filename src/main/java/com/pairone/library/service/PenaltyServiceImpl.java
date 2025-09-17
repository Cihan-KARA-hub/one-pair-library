package com.pairone.library.service;
import com.pairone.library.dto.penalty.*;
import com.pairone.library.entity.Loan;
import com.pairone.library.entity.Member;
import com.pairone.library.entity.Penalty;
import com.pairone.library.mapper.PenaltyMapper;
import com.pairone.library.repository.PenaltyRepository;
import com.pairone.library.rules.LoanBusinessRule; // LoanServiceImpl yerine
import com.pairone.library.rules.PenaltyBusinessRule;
import com.pairone.library.service.abstractservice.PenaltyService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PenaltyServiceImpl implements PenaltyService {
    private final PenaltyRepository penaltyRepository;
    private final LoanBusinessRule loanBusinessRule; // LoanServiceImpl yerine
    private final PenaltyBusinessRule penaltyBusinessRule;
    private final MemberServiceImpl memberServiceImpl;
    private final PenaltyMapper penaltyMapper;

    public PenaltyServiceImpl(PenaltyRepository penaltyRepository,
                              LoanBusinessRule loanBusinessRule, // LoanServiceImpl yerine
                              PenaltyBusinessRule penaltyBusinessRule,
                              MemberServiceImpl memberServiceImpl,
                              PenaltyMapper penaltyMapper) {
        this.penaltyRepository = penaltyRepository;
        this.loanBusinessRule = loanBusinessRule;
        this.penaltyBusinessRule = penaltyBusinessRule;
        this.memberServiceImpl = memberServiceImpl;
        this.penaltyMapper = penaltyMapper;
    }

    @Transactional
    public PenaltyCreateRes createPenalty(PenaltyCreateReq penalty) {
        penaltyBusinessRule.checkDuplicatePenalty(
                penalty.getLoanId(),
                penalty.getMemberId(),
                penalty.getPenaltyType()
        );

        Loan loan = loanBusinessRule.findLoanIsExists(penalty.getLoanId()); // Business rule kullanımı
        Member member = memberServiceImpl.EntityMemberById(penalty.getMemberId());
        Penalty pen = penaltyRepository.save(penaltyMapper.createToEntity(penalty, loan, member));
        return new PenaltyCreateRes(pen.getId(), pen.getPenaltyType(), pen.getMember().getPhone(), "penalty created");
    }

    public Page<PagePenaltyRes> getPenalties(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Penalty> penalties = penaltyRepository.findAll(pageable);
        return penalties.map(penaltyMapper::pageListDto);
    }

    public DeletePenaltyRes deleteId(Integer id) {
        Penalty penalty = penaltyBusinessRule.findPenaltyIsExists(id);
        penaltyRepository.deleteById(id);
        return new DeletePenaltyRes(penalty.getId(), penalty.getPenaltyType(), " Penalty deleted ");
    }

    @Transactional
    public PenaltyUpdateRes updatePenalty(PenaltyCreateReq penalty) {
        Loan loan = loanBusinessRule.findLoanIsExists(penalty.getLoanId()); // Business rule kullanımı
        Member member = memberServiceImpl.EntityMemberById(penalty.getMemberId());
        Penalty pen = penaltyRepository.save(penaltyMapper.createToEntity(penalty, loan, member));
        return new PenaltyUpdateRes(pen.getId(), pen.getPenaltyType(), pen.getMember().getPhone(), "penalty update");
    }
}