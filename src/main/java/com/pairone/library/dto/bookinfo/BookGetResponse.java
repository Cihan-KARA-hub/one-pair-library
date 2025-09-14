package com.pairone.library.dto.bookinfo;

public class BookGetResponse {
    private Integer bookId;
    private String isbn;
    private String title;
    private String status;
    private String type;
    private String language;
    private String condition;
    private int copyCount;
    private String location;
    private String barcode;
    public BookGetResponse(Integer bookId,
                           String isbn,
                           String title,
                           String status,
                           String type,
                           String language,
                           String condition,
                           int copyCount,
                           String location,
                           String barcode) {
        this.bookId = bookId;
        this.isbn = isbn;
        this.title = title;
        this.status = status;
        this.type = type;
        this.language = language;
        this.condition = condition;
        this.copyCount = copyCount;
        this.location = location;
        this.barcode = barcode;
    }

}
