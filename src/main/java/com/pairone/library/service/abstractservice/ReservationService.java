package com.pairone.library.service.abstractservice;
import com.pairone.library.dto.Reservation.ReservationRequest;
import com.pairone.library.dto.Reservation.ReservationResponse;
import java.util.List;

public interface ReservationService {

    // Yeni rezervasyon oluştur
    ReservationResponse createReservation(ReservationRequest request);

    // ID ile rezervasyon getir
    ReservationResponse getReservationById(Long id);

    // Tüm rezervasyonları getir
    List<ReservationResponse> getAllReservations();

    // Üyenin tüm rezervasyonlarını getir
    List<ReservationResponse> getReservationsByMemberId(Long memberId);

    // Rezervasyonu güncelle
    ReservationResponse updateReservation(Long id, ReservationRequest request);

    // Rezervasyonu sil
    void deleteReservation(Long id);

    // Rezervasyonu iptal et
    ReservationResponse cancelReservation(Long id);

    // Rezervasyonu tamamla / bitir
    ReservationResponse completeReservation(Long id);
}
