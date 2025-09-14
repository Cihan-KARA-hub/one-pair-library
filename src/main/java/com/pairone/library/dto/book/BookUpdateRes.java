package com.pairone.library.dto.book;

public class BookUpdateRes {
    private String bookName;

    private String Message;
    public BookUpdateRes(String bookName, String message) {
        this.bookName = bookName;
        Message = message;
    }
}
