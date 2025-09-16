package com.pairone.library.dto.book.response;

import jakarta.validation.constraints.NotNull;

public class BookDeleteResponse {
    @NotNull
    private int bookId;

    public BookDeleteResponse(int bookId) {
        this.bookId = bookId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
}
