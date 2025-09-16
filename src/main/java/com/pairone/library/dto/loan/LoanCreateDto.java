package com.pairone.library.dto.loan;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

import java.time.OffsetDateTime;

public class LoanCreateDto {
    private Integer id;

    @NotNull(message = "Kitap ID boş olamaz")
    @Positive(message = "Kitap ID pozitif olmalıdır")
    private Integer bookId;

    @NotNull(message = "Üye ID boş olamaz")
    @Positive(message = "Üye ID pozitif olmalıdır")
    private Integer memberId;

    @NotNull(message = "Talep tarihi boş olamaz")
    private OffsetDateTime requestDate;

    @NotNull(message = "Teslim tarihi boş olamaz")
    private OffsetDateTime dueDate;

    @NotBlank(message = "Status boş olamaz")
    @Pattern(regexp = "^(PENDING|ACTIVE|RETURNED|OVERDUE)$",
            message = "Status sadece PENDING, ACTIVE, RETURNED veya OVERDUE olabilir")
    private String status;

    private OffsetDateTime returnDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotNull(message = "Kitap ID boş olamaz") @Positive(message = "Kitap ID pozitif olmalıdır") Integer getBookId() {
        return bookId;
    }

    public void setBookId(@NotNull(message = "Kitap ID boş olamaz") @Positive(message = "Kitap ID pozitif olmalıdır") Integer bookId) {
        this.bookId = bookId;
    }

    public @NotNull(message = "Üye ID boş olamaz") @Positive(message = "Üye ID pozitif olmalıdır") Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(@NotNull(message = "Üye ID boş olamaz") @Positive(message = "Üye ID pozitif olmalıdır") Integer memberId) {
        this.memberId = memberId;
    }

    public @NotNull(message = "Talep tarihi boş olamaz") OffsetDateTime getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(@NotNull(message = "Talep tarihi boş olamaz") OffsetDateTime requestDate) {
        this.requestDate = requestDate;
    }

    public @NotNull(message = "Teslim tarihi boş olamaz") OffsetDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(@NotNull(message = "Teslim tarihi boş olamaz") OffsetDateTime dueDate) {
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

    public OffsetDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(OffsetDateTime returnDate) {
        this.returnDate = returnDate;
    }
}

