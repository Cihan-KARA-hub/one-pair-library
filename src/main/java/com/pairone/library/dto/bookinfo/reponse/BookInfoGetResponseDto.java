package com.pairone.library.dto.bookinfo.reponse;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class BookInfoGetResponseDto {
    @NotNull
    private Integer bookId;
    @NotBlank
    private String isbn;
    @NotBlank
    private String title;
    @NotBlank
    private String status;
    @NotBlank
    private String type;
    @NotBlank
    private String language;
    @NotBlank
    private String condition;
    @NotNull
    @Positive
    private int copyCount;
    @NotBlank
    private String location;
    @NotBlank
    private String barcode;

    public BookInfoGetResponseDto(int bookId,
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
