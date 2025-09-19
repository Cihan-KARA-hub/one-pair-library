package com.pairone.library.dto.loan;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public class LoanResponseDto {
    @NotNull(message = "ID boş olamaz")
    @Positive(message = "ID pozitif olmalıdır")
    private Integer id;

    private String returnDate;
    @NotBlank(message = "Kitap başlığı boş olamaz")
    @Pattern(regexp = "^[a-zA-ZğüşıöçĞÜŞIÖÇ0-9\\s.,:;!?()-]{2,100}$",
            message = "Kitap başlığı 2-100 karakter arası olmalı")
    private String bookTitle;
    @NotBlank(message = "Üye adı boş olamaz")
    @Pattern(regexp = "^[a-zA-ZğüşıöçĞÜŞIÖÇ\\s]{2,50}$",
            message = "Üye adı 2-50 karakter arası olmalı ve sadece harf içermeli")
    private String memberName;
    @NotBlank(message = "Talep tarihi boş olamaz")
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$",
            message = "Tarih formatı YYYY-MM-DD olmalıdır")
    private String requestDate;
    @NotBlank(message = "Teslim tarihi boş olamaz")
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$",
            message = "Tarih formatı YYYY-MM-DD olmalıdır")
    private String dueDate;
    @NotBlank(message = "Status boş olamaz")
    @Pattern(regexp = "^(PENDING|ACTIVE|RETURNED|OVERDUE)$",
            message = "Status sadece PENDING, ACTIVE, RETURNED veya OVERDUE olabilir")
    private String status;

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public @NotBlank(message = "Talep tarihi boş olamaz") @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$",
            message = "Tarih formatı YYYY-MM-DD olmalıdır") String getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(@NotBlank(message = "Talep tarihi boş olamaz") @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$",
            message = "Tarih formatı YYYY-MM-DD olmalıdır") String requestDate) {
        this.requestDate = requestDate;
    }

    public @NotNull(message = "ID boş olamaz") @Positive(message = "ID pozitif olmalıdır") Integer getId() {
        return id;
    }

    public void setId(@NotNull(message = "ID boş olamaz") @Positive(message = "ID pozitif olmalıdır") Integer id) {
        this.id = id;
    }

    public @NotBlank(message = "Kitap başlığı boş olamaz") @Pattern(regexp = "^[a-zA-ZğüşıöçĞÜŞIÖÇ0-9\\s.,:;!?()-]{2,100}$",
            message = "Kitap başlığı 2-100 karakter arası olmalı") String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(@NotBlank(message = "Kitap başlığı boş olamaz") @Pattern(regexp = "^[a-zA-ZğüşıöçĞÜŞIÖÇ0-9\\s.,:;!?()-]{2,100}$",
            message = "Kitap başlığı 2-100 karakter arası olmalı") String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public @NotBlank(message = "Üye adı boş olamaz") @Pattern(regexp = "^[a-zA-ZğüşıöçĞÜŞIÖÇ\\s]{2,50}$",
            message = "Üye adı 2-50 karakter arası olmalı ve sadece harf içermeli") String getMemberName() {
        return memberName;
    }

    public void setMemberName(@NotBlank(message = "Üye adı boş olamaz") @Pattern(regexp = "^[a-zA-ZğüşıöçĞÜŞIÖÇ\\s]{2,50}$",
            message = "Üye adı 2-50 karakter arası olmalı ve sadece harf içermeli") String memberName) {
        this.memberName = memberName;
    }

    public @NotBlank(message = "Teslim tarihi boş olamaz") @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$",
            message = "Tarih formatı YYYY-MM-DD olmalıdır") String getDueDate() {
        return dueDate;
    }

    public void setDueDate(@NotBlank(message = "Teslim tarihi boş olamaz") @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$",
            message = "Tarih formatı YYYY-MM-DD olmalıdır") String dueDate) {
        this.dueDate = dueDate;
    }

    public @NotBlank(message = "Status boş olamaz") @Pattern(regexp = "^(PENDING|ACTIVE|RETURNED|OVERDUE)$",
            message = "Status sadece PENDING, ACTIVE, RETURNED veya OVERDUE olabilir") String getStatus() {
        return status;
    }

    public void setStatus(@NotBlank(message = "Status boş olamaz") @Pattern(regexp = "^(PENDING|ACTIVE|RETURNED|OVERDUE)$",
            message = "Status sadece PENDING, ACTIVE, RETURNED veya OVERDUE olabilir") String status) {
        this.status = status;
    }

}


