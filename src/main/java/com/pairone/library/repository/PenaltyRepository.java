package com.pairone.library.repository;

import com.pairone.library.entity.Penalty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PenaltyRepository extends JpaRepository<Penalty, Integer> {
    boolean existsByLoanIdAndMemberIdAndPenaltyType(Integer loanId, Integer memberId, String penaltyType);
    //boolean existsByMemberIdAndIsPaid(Integer memberId, Boolean isPaid);
 //   java.util.List<Penalty> findByMemberIdAndIsReturned(Integer memberId, boolean isReturned);
    Optional<List<Penalty>> findByMemberId(Integer memberId);

}