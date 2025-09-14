package com.pairone.library.dto.penalty;

import java.math.BigDecimal;

public class PagePenaltyRes {
    private Integer id;
    private Integer memberId;
    private Integer loanId;
    private String penaltyType;
    private Integer delayDays;
    private boolean isReturned;
    private BigDecimal amount;

    public PagePenaltyRes(Integer id,
                          Integer memberId,
                          Integer loanId,
                          String penaltyType,
                          Integer delayDays,
                          boolean isReturned,
                          BigDecimal amount) {
        this.id = id;
        this.memberId = memberId;
        this.loanId = loanId;
        this.penaltyType = penaltyType;
        this.delayDays = delayDays;
        this.isReturned = isReturned;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer getLoanId() {
        return loanId;
    }

    public void setLoanId(Integer loanId) {
        this.loanId = loanId;
    }

    public String getPenaltyType() {
        return penaltyType;
    }

    public void setPenaltyType(String penaltyType) {
        this.penaltyType = penaltyType;
    }

    public Integer getDelayDays() {
        return delayDays;
    }

    public void setDelayDays(Integer delayDays) {
        this.delayDays = delayDays;
    }

    public boolean isReturned() {
        return isReturned;
    }

    public void setReturned(boolean returned) {
        isReturned = returned;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
