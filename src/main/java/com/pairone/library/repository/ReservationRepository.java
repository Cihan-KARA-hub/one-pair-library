package com.pairone.library.repository;
import com.pairone.library.entity.Member;
import com.pairone.library.entity.Book;
import com.pairone.library.entity.Reservation;
import com.pairone.library.entity.enums.ReservationStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.OffsetDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    boolean existsByMemberAndBookAndStatus(Member member, Book book, ReservationStatus status);

    Optional<Reservation> findByMemberIdAndBookIdAndStatus(Integer memberId, Integer bookId, ReservationStatus status);
    Optional<List<Reservation>> findByMemberId(Integer memberId);

    Optional<Reservation> findFirstByBookIdAndStatusOrderByReservationDateAsc(Integer book_id, ReservationStatus status);

    List<Reservation> findByExpireAtBefore(OffsetDateTime date);
}
