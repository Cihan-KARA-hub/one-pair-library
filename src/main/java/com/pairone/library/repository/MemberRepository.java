package com.pairone.library.repository;

import com.pairone.library.entity.Member;
import com.pairone.library.entity.enums.MembershipLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {
    Member findByemail(String email);
    boolean existsByIdAndMembershipLevel(int id, MembershipLevel membershipLevel);
}
