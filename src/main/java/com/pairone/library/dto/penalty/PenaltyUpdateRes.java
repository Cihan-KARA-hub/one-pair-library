package com.pairone.library.dto.penalty;

public class PenaltyUpdateRes {
    private Integer id;
    private String title;
    private String description;
    private String message;

    public PenaltyUpdateRes(Integer id, String title, String description, String message) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
