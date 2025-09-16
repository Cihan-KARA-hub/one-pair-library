package com.pairone.library.dto.loan;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
public class LoanCreateResponseDto {
    @NotNull(message = "Kitap ID boş olamaz")
    @Positive(message = "Kitap ID pozitif olmalıdır")
    private Integer bookId;

    @NotBlank(message = "Üye adı boş olamaz")
    @Pattern(regexp = "^[a-zA-ZğüşıöçĞÜŞIÖÇ\\s]{2,50}$",
            message = "Üye adı 2-50 karakter arası olmalı ve sadece harf içermeli")
    private String memberName;

    @NotNull(message = "Ödünç ID boş olamaz")
    @Positive(message = "Ödünç ID pozitif olmalıdır")
    private Integer loanId;
    public LoanCreateResponseDto(Integer bookId, String memberName, Integer loanId) {
        this.bookId = bookId;
        this.memberName = memberName;
        this.loanId = loanId;
    }

}
