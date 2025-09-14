package com.pairone.library.controller;

import com.pairone.library.dto.loan.*;
import com.pairone.library.service.LoanServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    private final LoanServiceImpl loanServiceImpl;

    public LoanController(LoanServiceImpl loanServiceImpl) {
        this.loanServiceImpl = loanServiceImpl;
    }

    @GetMapping
    public ResponseEntity<List<LoanListDto>> getAllLoans() {
        List<LoanListDto> loans = loanServiceImpl.getAllLoans();
        return ResponseEntity.ok(loans);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoanResponseDto> getLoanById(@PathVariable int id) {
        LoanResponseDto loan = loanServiceImpl.getLoanById(id);
        return ResponseEntity.ok(loan);
    }

    @PostMapping
    public ResponseEntity<
            LoanCreateResponseDto> createLoan(@RequestBody LoanCreateDto loanCreateDto) {
        LoanCreateResponseDto createdLoan = loanServiceImpl.createLoan(loanCreateDto);
        return ResponseEntity.ok(createdLoan);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LoanResponseDto> updateLoan(
            @PathVariable Integer id,
            @RequestBody LoanUpdateDto loanUpdateDto) {
        LoanResponseDto updatedLoan = loanServiceImpl.updateLoan(id, loanUpdateDto);
        return ResponseEntity.ok(updatedLoan);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLoan(
            @PathVariable Integer id) {
        loanServiceImpl.deleteLoan(id);
        return ResponseEntity.ok("Loan kaydı silindi. ID: " + id);
    }
}
