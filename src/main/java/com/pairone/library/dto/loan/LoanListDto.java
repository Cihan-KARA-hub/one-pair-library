package com.pairone.library.dto.loan;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
public class LoanListDto {
    @NotNull(message = "ID boş olamaz")
    @Positive(message = "ID pozitif olmalıdır")
    private Integer id;

    @NotBlank(message = "Kitap başlığı boş olamaz")
    private String bookTitle;

    @NotBlank(message = "Üye adı boş olamaz")
    @Pattern(regexp = "^[a-zA-ZğüşıöçĞÜŞIÖÇ\\s]{2,50}$",
            message = "Üye adı 2-50 karakter arası olmalı ve sadece harf içermeli")
    private String memberName;

    @NotBlank(message = "Talep tarihi boş olamaz")
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$",
            message = "Talep tarihi YYYY-MM-DD formatında olmalıdır")
    private String requestDate; // "2024-01-15" format

    @NotBlank(message = "Teslim tarihi boş olamaz")
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$",
            message = "Teslim tarihi YYYY-MM-DD formatında olmalıdır")
    private String dueDate; // "2024-01-29" format

    @NotBlank(message = "Status boş olamaz")
    @Pattern(regexp = "^(PENDING|ACTIVE|RETURNED|OVERDUE)$",
            message = "Status sadece PENDING, ACTIVE, RETURNED veya OVERDUE olabilir")
    private String status;

    // Getter & Setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
