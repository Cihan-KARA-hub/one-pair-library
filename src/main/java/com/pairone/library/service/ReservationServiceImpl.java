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
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import com.pairone.library.repository.MemberRepository;
import com.pairone.library.repository.BookRepository;
import com.pairone.library.repository.MemberRepository;
import com.pairone.library.repository.BookRepository;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final ReservationBusinessRules reservationBusinessRules;
    private final MemberRepository memberRepository;
    private final BookRepository bookRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository,
                                  ReservationBusinessRules reservationBusinessRules,
                                  MemberRepository memberRepository,
                                  BookRepository bookRepository) {
        this.reservationRepository = reservationRepository;
        this.reservationBusinessRules = reservationBusinessRules;
        this.memberRepository = memberRepository;
        this.bookRepository = bookRepository;
    }
    @Override
public ReservationResponse createReservation(ReservationRequest request) {
//        Member member = ...; // memberRepository.findById
//        Book book = ...;     // bookRepository.findById
    Member member = memberRepository.findById(request.getMemberId().intValue())
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Member not found"));
    Book book = bookRepository.findById(request.getBookId().intValue())
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found"));


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

    @Override
    public ReservationResponse getReservationById(Long id) {
        return null;
    }

    @Override
    public List<ReservationResponse> getAllReservations() {
        return List.of();
    }

    @Override
    public List<ReservationResponse> getReservationsByMemberId(Long memberId) {
        return List.of();
    }

    @Override
    public ReservationResponse updateReservation(Long id, ReservationRequest request) {
        return null;
    }

    @Override
    public void deleteReservation(Long id) {

    }

    @Override
    public ReservationResponse cancelReservation(Long id) {
        return null;
    }

    @Override
    public ReservationResponse completeReservation(Long id) {
        return null;
    }

    private ReservationResponse mapToResponse(Reservation saved) {
        return null;
    }



}
