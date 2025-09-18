package com.pairone.library.repository;
import com.pairone.library.entity.Member;
import com.pairone.library.entity.Book;
import com.pairone.library.entity.Reservation;
import com.pairone.library.entity.enums.ReservationStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    boolean existsByMemberAndBookAndStatus(Member member, Book book, ReservationStatus status);

    Collection<Object> findByMemberId(Long memberId);
}
