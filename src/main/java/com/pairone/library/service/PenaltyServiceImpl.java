package com.pairone.library.service;

import com.pairone.library.dto.penalty.*;
import com.pairone.library.entity.Loan;
import com.pairone.library.entity.Member;
import com.pairone.library.entity.Penalty;
import com.pairone.library.mapper.PenaltyMapper;
import com.pairone.library.repository.PenaltyRepository;
import com.pairone.library.service.abstractservice.PenaltyService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PenaltyServiceImpl implements PenaltyService {
    private final PenaltyRepository penaltyRepository;
    private final LoanServiceImpl loanServiceImpl;
    private final MemberServiceImpl memberServiceImpl;
    private final PenaltyMapper penaltyMapper;


    public PenaltyServiceImpl(PenaltyRepository penaltyRepository,
                              LoanServiceImpl loanServiceImpl,
                              MemberServiceImpl memberServiceImpl,
                              PenaltyMapper penaltyMapper) {
        this.penaltyRepository = penaltyRepository;
        this.loanServiceImpl = loanServiceImpl;
        this.memberServiceImpl = memberServiceImpl;
        this.penaltyMapper = penaltyMapper;
    }

    @Transactional
    public PenaltyCreateRes createPenalty(PenaltyCreateReq penalty) {
        Loan loan = loanServiceImpl.entityLoanById(penalty.getLoanId());
        Member member = memberServiceImpl.EntityMemberById(penalty.getMemberId());
        Penalty pen = penaltyRepository.save(penaltyMapper.createToEntity(penalty, loan, member));
        return new PenaltyCreateRes(pen.getId(), pen.getPenaltyType(), pen.getMember().getPhone(), "penalty created");
    }

    public Page<PagePenaltyRes> getPenalties(int page, int size) {
        Pageable pageable = PageRequest.of(size, page);
        Page<Penalty> penalties = penaltyRepository.findAll(pageable);
        return penalties.map(penaltyMapper::pageListDto);

    }

    public DeletePenaltyRes deleteId(Integer id) {
        Penalty penalty = penaltyRepository.findById(id).orElseThrow(() -> new RuntimeException("Penalty not found"));
        penaltyRepository.deleteById(id);
        return new DeletePenaltyRes(penalty.getId(), penalty.getPenaltyType(), " Penalty deleted ");
    }

    @Transactional
    public PenaltyUpdateRes updatePenalty(PenaltyCreateReq penalty) {
        Loan loan = loanServiceImpl.entityLoanById(penalty.getLoanId());
        Member member = memberServiceImpl.EntityMemberById(penalty.getMemberId());
        Penalty pen = penaltyRepository.save(penaltyMapper.createToEntity(penalty, loan, member));
        return new PenaltyUpdateRes(pen.getId(), pen.getPenaltyType(), pen.getMember().getPhone(), "penalty update");
    }
}
