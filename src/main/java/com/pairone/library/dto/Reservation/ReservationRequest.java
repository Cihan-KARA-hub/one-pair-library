package com.pairone.library.dto.Reservation;

import java.time.LocalDateTime;

public class ReservationRequest {

    private Long memberId;
    private Long bookId;

    // Opsiyonel: manuel tarih atanacaksa
    private LocalDateTime reservationDate;
    private LocalDateTime expireAt;

    // Getter ve Setter
    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public LocalDateTime getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDateTime reservationDate) {
        this.reservationDate = reservationDate;
    }

    public LocalDateTime getExpireAt() {
        return expireAt;
    }

    public void setExpireAt(LocalDateTime expireAt) {
        this.expireAt = expireAt;
    }
}
