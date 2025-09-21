package com.pairone.library.dto.reservation.response;

public class ReservationSetStatusResponse {
    private boolean success;

    public ReservationSetStatusResponse(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
