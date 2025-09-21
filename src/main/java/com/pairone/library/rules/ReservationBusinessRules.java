package com.pairone.library.rules;

import com.pairone.library.core.exception.type.BusinessException;
import com.pairone.library.entity.Book;
import com.pairone.library.entity.Member;
import com.pairone.library.entity.Reservation;
import com.pairone.library.entity.enums.ReservationStatus;
import com.pairone.library.repository.ReservationRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ReservationBusinessRules {

    private final ReservationRepository reservationRepository;
    private final PenaltyBusinessRule penaltyBusinessRule;

    public ReservationBusinessRules(ReservationRepository reservationRepository, PenaltyBusinessRule penaltyBusinessRule) {
        this.reservationRepository = reservationRepository;
        this.penaltyBusinessRule = penaltyBusinessRule;
    }

    public void reservationMustNotExistWithSameId(Integer id) {
        Optional<Reservation> reservation = reservationRepository.findById(id);
        if (reservation.isPresent()) {
            throw new BusinessException("reservation not found");
        }
    }

    public Reservation reservationMustExistWithSameId(Integer id) {
        return reservationRepository.findById(id).orElseThrow(() -> new BusinessException("reservation not found"));
    }

    public void shouldNotFindByMemberIdBookIdAndStatus(Integer memberId, Integer bookId, ReservationStatus status) {
        Optional<Reservation> reservation = reservationRepository.findByMemberIdAndBookIdAndStatus(memberId, bookId, status);
        if (reservation.isPresent()) {
            throw new BusinessException("reservation not found");
        }
    }

    // BANNED üyeler rezervasyon yapamaz
    public void checkIfMemberBanned(Member member) {
        if (member.getRole() != null) {
            member.getRole();
            //    if (member.getRole() != null && member.getRole().getType() == RoleType.BANNED) {
            //            throw new IllegalStateException("BANNED üyeler rezervasyon yapamaz!");
        }
    }

    public void checkMemberHasNoUnpaidFines(Member member) {
        penaltyBusinessRule.validateMemberHasNoUnpaidFines(member.getId());
    }

    // Aynı kitap için aktif rezervasyon yapılamaz
    public void checkIfMemberHasActiveReservation(Member member, Book book) {
        boolean exists = reservationRepository.existsByMemberAndBookAndStatus(member, book, ReservationStatus.ACTIVE);
        if (exists) {
            throw new BusinessException("Bu kitap için zaten aktif rezervasyonunuz var!");
        }
    }

    public List<Reservation> getMember(Integer memberId) {
        return reservationRepository.findByMemberId(memberId).orElseThrow(() -> new BusinessException("reservation not found"));
    }
}
