package com.pairone.library.dto.bookinfo.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class BookInfoUpdateRequestDto {
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
    @NotNull
    @Positive
    private int totalCopy;
    @NotNull

    @Positive
    private int availableCopies;

    @NotNull
    @Positive
    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(@NotNull @Positive int availableCopies) {
        this.availableCopies = availableCopies;
    }

    @NotNull
    @Positive
    public int getTotalCopy() {
        return totalCopy;
    }

    public void setTotalCopy(@NotNull @Positive int totalCopy) {
        this.totalCopy = totalCopy;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
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

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
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
