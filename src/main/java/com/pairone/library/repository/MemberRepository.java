package com.pairone.library.repository;

import com.pairone.library.entity.Member;
import com.pairone.library.entity.Penalty;
import com.pairone.library.entity.enums.MembershipLevel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {
    Member findByemail(String email);
    boolean existsByIdAndMembershipLevel(int id, MembershipLevel membershipLevel);
    @Query("""
    SELECT m 
    FROM Member m 
    WHERE (:email IS NULL OR LOWER(m.eMail) LIKE LOWER(CONCAT('%', :email, '%')))
      AND (:status IS NULL OR 
           ( :status = 'ACTIVE' AND m.isActive = true ) OR 
           ( :status = 'INACTIVE' AND m.isActive = false ))
""")
    Page<Member> filterQueryquery(@Param("email") String email,@Param("status") String status, Pageable pageable);


    @Query("SELECT p FROM Member m " +
            "JOIN m.penalties p " +
            "WHERE m.id = :memberId " +
            "AND p.isReturned = :isPaid")
    List<Penalty> findMemberFinesByPaidStatus(@Param("memberId") Integer memberId,
                                              @Param("isPaid") boolean isPaid);
}
