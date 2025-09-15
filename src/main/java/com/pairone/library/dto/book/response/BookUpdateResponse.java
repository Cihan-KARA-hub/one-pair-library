package com.pairone.library.dto.book.response;

public class BookUpdateResponse {
    private String bookName;

    private String Message;
    public BookUpdateResponse(String bookName, String message) {
        this.bookName = bookName;
        Message = message;
    }
}
