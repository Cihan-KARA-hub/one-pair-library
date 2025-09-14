package com.pairone.library.dto.penalty;

public class DeletePenaltyRes {
    private Integer id;
    private String title;
    private String message;

    public DeletePenaltyRes(Integer id, String title, String message) {
        this.id = id;
        this.title = title;
        this.message = message;
    }
}
