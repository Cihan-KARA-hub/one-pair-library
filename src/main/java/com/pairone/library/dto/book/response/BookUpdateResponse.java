package com.pairone.library.dto.book.response;

import jakarta.validation.constraints.NotBlank;

public class BookUpdateResponse {
    @NotBlank
    private String name;

    public BookUpdateResponse(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
