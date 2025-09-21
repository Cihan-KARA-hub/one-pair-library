package com.pairone.library.mapper;

import com.pairone.library.dto.reservation.request.ReservationCreateRequest;
import com.pairone.library.dto.reservation.response.ReservationGetResponse;
import com.pairone.library.dto.reservation.response.ReservationResponse;
import com.pairone.library.entity.Book;
import com.pairone.library.entity.Member;
import com.pairone.library.entity.Reservation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ReservationMapper {
    ReservationMapper INSTANCE = Mappers.getMapper(ReservationMapper.class);

    @Mapping(target = "reservationId", ignore = true)
    @Mapping(target = "reservationDate", ignore = true)
    @Mapping(target = "expireAt", ignore = true)
    @Mapping(target = "status", ignore = true)
    Reservation reservationCreateRequestMapToEntity(ReservationCreateRequest dto, Book book, Member member);

    ReservationResponse entityMapToReservationResponse(Reservation reservation);

    ReservationGetResponse entityMapToReservationGetResponse(Reservation res);
}
