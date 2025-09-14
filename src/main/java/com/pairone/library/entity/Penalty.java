package com.pairone.library.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "penalty")
public class Penalty {
    /* penalty_id int
 member_id int
 loan_id int
 penalty_type varchar
 delay_days int
 is_returned boolean
 amount decimal
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "penalty_id")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;
    @ManyToOne
    @JoinColumn(name = "loan_id", nullable = false)
    private Loan loan;
    @Column(name = "penalty_type", length = 50, nullable = false)
    private String penaltyType;
    @Column(name = "delay_days")
    private Integer delayDays;
    @Column(name = "is_returned", nullable = false)
    private boolean isReturned;
    @Column(name = "amount", precision = 10, scale = 2, nullable = false)
    private BigDecimal amount;

    public Penalty() {
    }

    public Penalty(Integer id,
                   Member member,
                   Loan loan,
                   String penaltyType,
                   Integer delayDays,
                   boolean isReturned,
                   BigDecimal amount) {
        this.id = id;
        this.member = member;
        this.loan = loan;
        this.penaltyType = penaltyType;
        this.delayDays = delayDays;
        this.isReturned = isReturned;
        this.amount = amount;
    }

    public String getPenaltyType() {
        return penaltyType;
    }

    public void setPenaltyType(String penaltyType) {
        this.penaltyType = penaltyType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
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
