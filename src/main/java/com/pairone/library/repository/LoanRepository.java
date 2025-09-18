package com.pairone.library.repository;

import com.pairone.library.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer> {
    boolean existsByBookIdAndMemberIdAndIsReturnedFalse(Integer bookId, Integer memberId);
    List<Loan> findByMemberIdAndStatus(Integer memberId, String status);
}