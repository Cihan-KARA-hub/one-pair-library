package com.pairone.library.dto.bookinfo.reponse;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class BookInfoCreateResponseDto {
    @NotNull
    private Integer bookId;
    @NotBlank
    private String isbn;

    public @NotNull Integer getBookId() {
        return bookId;
    }

    public void setBookId(@NotNull Integer bookId) {
        this.bookId = bookId;
    }

    public @NotBlank String getIsbn() {
        return isbn;
    }

    public void setIsbn(@NotBlank String isbn) {
        this.isbn = isbn;
    }
}
