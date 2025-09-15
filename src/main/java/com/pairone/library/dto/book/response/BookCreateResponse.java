package com.pairone.library.dto.book.response;

public class BookCreateResponse {
    private String name;

    public BookCreateResponse(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
