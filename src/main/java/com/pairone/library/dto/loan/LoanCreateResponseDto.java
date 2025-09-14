package com.pairone.library.dto.loan;

public class LoanCreateResponseDto {
    private Integer bookId;
    private String memberName;
    private Integer loanId;
    public LoanCreateResponseDto(Integer bookId, String memberName, Integer loanId) {
        this.bookId = bookId;
        this.memberName = memberName;
        this.loanId = loanId;
    }

}
