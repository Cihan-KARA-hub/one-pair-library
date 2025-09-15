package com.pairone.library.dto.book.response;

public class BookDeleteResponseDto {
    private int bookId;

    public BookDeleteResponseDto(int bookId) {
        this.bookId = bookId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
}
