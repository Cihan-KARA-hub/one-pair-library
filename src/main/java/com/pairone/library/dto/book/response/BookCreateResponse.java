package com.pairone.library.dto.book.response;

public class BookCreateResponse {
    private String bookName;

    private String Message;
    public BookCreateResponse(String bookName, String message) {
        this.bookName = bookName;
        Message = message;
    }
}
