package com.pairone.library.dto.book.response;

public class BookListPublisherDto {
    String publisherName;

    public BookListPublisherDto(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }
}
