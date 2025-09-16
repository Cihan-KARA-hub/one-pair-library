package com.pairone.library.dto.loan;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
public class LoanUpdateDto {
    @NotNull(message = "ID boş olamaz")
    @Positive(message = "ID pozitif olmalıdır")
    private Long id;

    @NotBlank(message = "Teslim tarihi boş olamaz")
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$",
            message = "Tarih formatı YYYY-MM-DD olmalıdır")
    private String dueDate;

    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$",
            message = "Tarih formatı YYYY-MM-DD olmalıdır")
    private String returnDate; // İade edilmediği durumda null

    @NotBlank(message = "Status boş olamaz")
    @Pattern(regexp = "^(PENDING|ACTIVE|RETURNED|OVERDUE)$",
            message = "Status sadece PENDING, ACTIVE, RETURNED veya OVERDUE olabilir")
    private String status;

    // Getter & Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
