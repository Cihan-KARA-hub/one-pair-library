package com.pairone.library.dto.loan;

import java.time.OffsetDateTime;

public class LoanReturnDto {

    private Integer loanId;
    private OffsetDateTime returnDate;

    public LoanReturnDto() {
    }

    public LoanReturnDto(Integer loanId, OffsetDateTime returnDate) {
        this.loanId = loanId;
        this.returnDate = returnDate;
    }

    public Integer getLoanId() {
        return loanId;
    }

    public void setLoanId(Integer loanId) {
        this.loanId = loanId;
    }

    public OffsetDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(OffsetDateTime returnDate) {
        this.returnDate = returnDate;
    }
}
