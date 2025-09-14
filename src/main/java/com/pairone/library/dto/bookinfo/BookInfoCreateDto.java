package com.pairone.library.dto.bookinfo;


public class BookInfoCreateDto {
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

    public BookInfoCreateDto(int bookId,
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

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public int getCopyCount() {
        return copyCount;
    }

    public void setCopyCount(int copyCount) {
        this.copyCount = copyCount;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }
}
