package com.pairone.library.service;

import com.pairone.library.core.exception.type.BusinessException;
import com.pairone.library.dto.reservation.request.ReservationCreateRequest;
import com.pairone.library.dto.reservation.response.ReservationGetResponse;
import com.pairone.library.dto.reservation.response.ReservationResponse;
import com.pairone.library.dto.reservation.response.ReservationSetStatusResponse;
import com.pairone.library.entity.Book;
import com.pairone.library.entity.Member;
import com.pairone.library.entity.Reservation;
import com.pairone.library.entity.enums.BookStatus;
import com.pairone.library.entity.enums.ReservationStatus;
import com.pairone.library.mapper.ReservationMapper;
import com.pairone.library.repository.ReservationRepository;
import com.pairone.library.rules.BookBusinessRule;
import com.pairone.library.rules.BookInfoBusinessRule;
import com.pairone.library.rules.MemberBusinessRule;
import com.pairone.library.rules.ReservationBusinessRules;
import com.pairone.library.service.abstractservice.ReservationService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final ReservationBusinessRules reservationBusinessRules;
    private final ReservationMapper reservationMapper;
    private final MemberBusinessRule memberBusinessRule;
    private final BookBusinessRule bookBusinessRule;
    private final BookInfoBusinessRule bookInfoBusinessRule;


    public ReservationServiceImpl(ReservationRepository reservationRepository,
                                  ReservationBusinessRules reservationBusinessRules,
                                  ReservationMapper reservationMapper, MemberBusinessRule memberBusinessRule, BookBusinessRule bookBusinessRule, BookInfoBusinessRule bookInfoBusinessRule) {
        this.reservationRepository = reservationRepository;
        this.reservationBusinessRules = reservationBusinessRules;
        this.memberBusinessRule = memberBusinessRule;
        this.bookBusinessRule = bookBusinessRule;
        this.bookInfoBusinessRule = bookInfoBusinessRule;
        this.reservationMapper = ReservationMapper.INSTANCE;

    }

    @Override
    public ReservationResponse createReservation(ReservationCreateRequest request) {
        reservationBusinessRules.shouldNotFindByMemberIdBookIdAndStatus(
                request.getMemberId(), request.getBookId(), ReservationStatus.ACTIVE);
        Member member = memberBusinessRule.findByMember(request.getMemberId());
        Book book = bookBusinessRule.findBookIsExists(request.getBookId());
        if (book.getBookinfoId().getAvailableCopies() != 0)
            throw new BusinessException("You cannot create a reservation. Book is available.");
        Reservation reservation = reservationMapper.reservationCreateRequestMapToEntity(request, book, member);
        bookBusinessRule.decreaseAvailableCopies(book.getId());
        reservation.setStatus(ReservationStatus.PENDING);
        reservationRepository.save(reservation);
        trigger(book);
        return reservationMapper.entityMapToReservationResponse(reservation);
    }

    @Override
    public ReservationGetResponse getReservationById(Integer id) {
        Reservation res = reservationBusinessRules.reservationMustExistWithSameId(id);
        return reservationMapper.entityMapToReservationGetResponse(res);
    }

    @Override
    public List<ReservationGetResponse> getAllReservations() {
        List<Reservation> reservations = reservationRepository.findAll();
        return reservations.stream().map(reservationMapper::entityMapToReservationGetResponse).toList();

    }

    @Override
    public List<ReservationGetResponse> getReservationsByMemberId(Integer memberId) {
        List<Reservation> reservation = reservationBusinessRules.getMember(memberId);
        return reservation.stream().map(reservationMapper::entityMapToReservationGetResponse).toList();

    }

    @Override
    //yumuşak silme iptal et
    public void deleteReservation(Integer id) {
        Reservation res = reservationBusinessRules.reservationMustExistWithSameId(id);
        res.setStatus(ReservationStatus.CANCELLED);
        reservationRepository.delete(res);
    }

    @Override
    public ReservationSetStatusResponse setStatus(Integer id, ReservationStatus status) {
        Reservation res = reservationBusinessRules.reservationMustExistWithSameId(id);
        Book book = bookBusinessRule.findBookIsExists(id);
        setStatusUpdateBook(status, book);
        res.setStatus(status);
        return new ReservationSetStatusResponse(true);
    }

    @Override
    @Scheduled(fixedRate = 10000)
    public void expireAt() {
        OffsetDateTime date = OffsetDateTime.now().minusHours(24);
        List<Reservation> res = reservationRepository.findByExpireAtBefore(date);
        res.forEach(reservation -> {
            Book book = bookBusinessRule.findBookIsExists(reservation.getBook().getId());
            bookBusinessRule.incrementBook(reservation.getBook().getId());
            reservation.setStatus(ReservationStatus.EXPIRED);
            reservationRepository.save(reservation);
            trigger(book);
        });
    }

    @Override
    public void trigger(Book book) {
        Optional<Reservation> res = reservationRepository
                .findFirstByBookIdAndStatusOrderByReservationDateAsc(book.getId(), ReservationStatus.PENDING);
        if (res.isPresent()) {
            book.setBookStatus(BookStatus.RESERVE);
            bookBusinessRule.update(book);
            bookBusinessRule.decreaseAvailableCopies(res.get().getBook().getId());
            res.get().setStatus(ReservationStatus.ACTIVE);
            res.get().setExpireAt(OffsetDateTime.now().plusHours(24));
            reservationRepository.save(res.get());
        }
    }


    private ReservationResponse mapToResponse(Reservation saved) {
        return null;
    }

    private void setStatusUpdateBook(ReservationStatus status, Book book) {
        if (status == ReservationStatus.CANCELLED || status == ReservationStatus.FULFILLED || status == ReservationStatus.EXPIRED) {
            bookBusinessRule.incrementBook(book.getId());
        } else {
            bookBusinessRule.decreaseAvailableCopies(book.getId());
        }
    }


}
