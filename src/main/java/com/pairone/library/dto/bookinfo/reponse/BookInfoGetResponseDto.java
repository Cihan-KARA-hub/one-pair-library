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

    public BookInfoGetResponseDto() {
    }

    public BookInfoGetResponseDto(Integer bookId,
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

    public @NotNull Integer getBookId() {
        return bookId;
    }

    public void setBookId(@NotNull Integer bookId) {
        this.bookId = bookId;
    }

    public @NotBlank String getIsbn() {
        return isbn;
    }

    public void setIsbn(@NotBlank String isbn) {
        this.isbn = isbn;
    }

    public @NotBlank String getTitle() {
        return title;
    }

    public void setTitle(@NotBlank String title) {
        this.title = title;
    }

    public @NotBlank String getStatus() {
        return status;
    }

    public void setStatus(@NotBlank String status) {
        this.status = status;
    }

    public @NotBlank String getType() {
        return type;
    }

    public void setType(@NotBlank String type) {
        this.type = type;
    }

    public @NotBlank String getLanguage() {
        return language;
    }

    public void setLanguage(@NotBlank String language) {
        this.language = language;
    }

    public @NotBlank String getCondition() {
        return condition;
    }

    public void setCondition(@NotBlank String condition) {
        this.condition = condition;
    }

    @NotNull
    @Positive
    public int getCopyCount() {
        return copyCount;
    }

    public void setCopyCount(@NotNull @Positive int copyCount) {
        this.copyCount = copyCount;
    }

    public @NotBlank String getLocation() {
        return location;
    }

    public void setLocation(@NotBlank String location) {
        this.location = location;
    }

    public @NotBlank String getBarcode() {
        return barcode;
    }

    public void setBarcode(@NotBlank String barcode) {
        this.barcode = barcode;
    }
}
