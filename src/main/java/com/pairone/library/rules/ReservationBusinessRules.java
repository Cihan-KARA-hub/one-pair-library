package com.pairone.library.rules;
import com.pairone.library.entity.Book;
import com.pairone.library.entity.Member;
import com.pairone.library.entity.enums.ReservationStatus;
import com.pairone.library.entity.enums.RoleType;
import com.pairone.library.repository.ReservationRepository;
import org.springframework.stereotype.Component;

@Component
public class ReservationBusinessRules {

    private final ReservationRepository reservationRepository;

    public ReservationBusinessRules(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    // BANNED üyeler rezervasyon yapamaz
    public void checkIfMemberBanned(Member member) {
        if (member.getRole() != null) {
            member.getRole();
            //    if (member.getRole() != null && member.getRole().getType() == RoleType.BANNED) {
            //            throw new IllegalStateException("BANNED üyeler rezervasyon yapamaz!");
        }
    }

    // Aynı kitap için aktif rezervasyon yapılamaz
    public void checkIfMemberHasActiveReservation(Member member, Book book) {
        boolean exists = reservationRepository.existsByMemberAndBookAndStatus(member, book, ReservationStatus.ACTIVE);
        if (exists) {
            throw new IllegalStateException("Bu kitap için zaten aktif rezervasyonunuz var!");
        }
    }
}
