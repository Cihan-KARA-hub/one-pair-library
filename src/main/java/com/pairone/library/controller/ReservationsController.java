package com.pairone.library.controller;

import com.pairone.library.dto.reservation.request.ReservationCreateRequest;
import com.pairone.library.dto.reservation.response.ReservationResponse;
import com.pairone.library.service.abstractservice.ReservationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reservations")
public class ReservationsController {
    private final ReservationService reservationService;

    public ReservationsController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    // • POST /api/reservations → ReservationCreateRequest → ReservationResponse
    @PostMapping()
    public ReservationResponse create(@RequestBody ReservationCreateRequest reservationCreateRequest) {
            return  reservationService.createReservation(reservationCreateRequest);
    }
    //• POST /api/reservations/{id}/cancel

    //• POST /api/reservations/fulfill-next?bookId=... (stok/iadede tetikleme)

}
