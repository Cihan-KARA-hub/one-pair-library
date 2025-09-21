package com.pairone.library.service.abstractservice;

import com.pairone.library.dto.reservation.request.ReservationCreateRequest;
import com.pairone.library.dto.reservation.response.ReservationGetResponse;
import com.pairone.library.dto.reservation.response.ReservationResponse;
import com.pairone.library.dto.reservation.response.ReservationSetStatusResponse;
import com.pairone.library.entity.Book;
import com.pairone.library.entity.enums.ReservationStatus;

import java.util.List;

public interface ReservationService {

    // Yeni rezervasyon oluştur

    ReservationResponse createReservation(ReservationCreateRequest request);

    // ID ile rezervasyon getir
    ReservationGetResponse getReservationById(Integer id);

    // Tüm rezervasyonları getir
    List<ReservationGetResponse> getAllReservations();

    // Üyenin tüm rezervasyonlarını getir
    List<ReservationGetResponse> getReservationsByMemberId(Integer memberId);

    // Rezervasyonu güncelle
    // ReservationResponse updateReservation(Integer id, ReservationCreateRequest request);

    // Rezervasyonu sil
    void deleteReservation(Integer id);

    // Rezervasyonu iptal et
  //  ReservationResponse cancelReservation(Integer id);

    // Rezervasyonu tamamla / bitir
  //  ReservationResponse completeReservation(Integer id);

    ReservationSetStatusResponse setStatus(Integer id, ReservationStatus status);
     void expireAt();

    void trigger( Book book);
}
