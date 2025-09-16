package com.pairone.library.dto.bookinfo.reponse;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class BookInfoUpdateResponseDto {
    @NotNull
    private Integer bookId;
    @NotBlank
    private String isbn;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
