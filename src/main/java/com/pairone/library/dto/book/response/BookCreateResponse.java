package com.pairone.library.dto.book.response;

import jakarta.validation.constraints.NotBlank;

public class BookCreateResponse {
    @NotBlank
    private String name;


    public BookCreateResponse(String name) {
        this.name = name;
    }

    public @NotBlank String getName() {
        return name;
    }

    public void setName(@NotBlank String name) {
        this.name = name;
    }
}
