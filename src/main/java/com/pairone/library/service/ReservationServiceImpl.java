package com.pairone.library.service;
import com.pairone.library.dto.Reservation.ReservationRequest;
import com.pairone.library.dto.Reservation.ReservationResponse;
import com.pairone.library.entity.Reservation;
import com.pairone.library.entity.enums.ReservationStatus;
import com.pairone.library.service.abstractservice.ReservationService;
import com.pairone.library.repository.ReservationRepository;
import com.pairone.library.entity.Member;
import com.pairone.library.entity.Book;
import com.pairone.library.rules.ReservationBusinessRules;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final ReservationBusinessRules reservationBusinessRules;

    public ReservationServiceImpl(ReservationRepository reservationRepository,
                                  ReservationBusinessRules reservationBusinessRules) {
        this.reservationRepository = reservationRepository;
        this.reservationBusinessRules = reservationBusinessRules;
    }

    @Override
    public ReservationResponse createReservation(ReservationRequest request) {
        Member member = ...; // memberRepository.findById
        Book book = ...;     // bookRepository.findById

        reservationBusinessRules.checkIfMemberBanned(member);
        reservationBusinessRules.checkIfMemberHasActiveReservation(member, book);

        Reservation reservation = new Reservation();
        reservation.setMember(member);
        reservation.setBook(book);
        reservation.setReservationDate(LocalDateTime.now());
        reservation.setStatus(String.valueOf(ReservationStatus.ACTIVE));

        Reservation saved = reservationRepository.save(reservation);
        return mapToResponse(saved);
    }

    private ReservationResponse mapToResponse(Reservation saved) {
        return null;
    }
}
