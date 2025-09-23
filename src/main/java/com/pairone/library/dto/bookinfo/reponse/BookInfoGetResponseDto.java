package com.pairone.library.dto.bookinfo.reponse;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class BookInfoGetResponseDto {
    @NotNull
    private Integer bookId;
    @NotBlank
    private String isbn;
    private int totalCopy;
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
    private int availableCopies;
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
                                  String location,
                                  String barcode,
                                  int totalCopy) {
        this.bookId = bookId;
        this.isbn = isbn;
        this.title = title;
        this.status = status;
        this.type = type;
        this.language = language;
        this.condition = condition;
        this.location = location;
        this.barcode = barcode;
        this.totalCopy = totalCopy;
    }

    @NotNull
    @Positive
    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(@NotNull @Positive int availableCopies) {
        this.availableCopies = availableCopies;
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
        return availableCopies;
    }

    public void setCopyCount(@NotNull @Positive int copyCount) {
        this.availableCopies = copyCount;
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

    public int getTotalCopy() {
        return totalCopy;
    }

    public void setTotalCopy(int totalCopy) {
        this.totalCopy = totalCopy;
    }
}
