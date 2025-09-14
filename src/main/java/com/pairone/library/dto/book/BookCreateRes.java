package com.pairone.library.dto.book;

import com.pairone.library.entity.Author;

import java.util.List;

public class BookCreateRes {
    private String bookName;

    private String Message;
    public BookCreateRes(String bookName, String message) {
        this.bookName = bookName;
        Message = message;
    }
}
