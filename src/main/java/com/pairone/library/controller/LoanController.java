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

    // Tüm loanlar
    @GetMapping
    public ResponseEntity<List<LoanListDto>> getAllLoans() {
        return ResponseEntity.ok(loanServiceImpl.getAllLoans());
    }

    // Tek loan
    @GetMapping("/{id}")
    public ResponseEntity<LoanResponseDto> getLoanById(@PathVariable int id) {
        return ResponseEntity.ok(loanServiceImpl.getLoanById(id));
    }

    // Loan oluşturma
    @PostMapping
    public ResponseEntity<LoanCreateResponseDto> createLoan(
            @RequestBody LoanCreateDto loanCreateDto) {
        return ResponseEntity.ok(loanServiceImpl.createLoan(loanCreateDto));
    }

    // Loan iade etme
    @PostMapping("/return")
    public ResponseEntity<LoanResponseDto> returnLoan(
            @RequestBody LoanReturnDto loanReturnDto) {
        return ResponseEntity.ok(loanServiceImpl.returnLoan(loanReturnDto));
    }

    // Üye bazlı açık ödünçler
    @GetMapping("/members/{memberId}")
    public ResponseEntity<List<LoanListDto>> getMemberLoans(
            @PathVariable Integer memberId,
            @RequestParam(defaultValue = "BORROWED") String status) {
        return ResponseEntity.ok(loanServiceImpl.getMemberLoans(memberId, status));
    }

    // Loan güncelle
    @PutMapping("/{id}")
    public ResponseEntity<LoanResponseDto> updateLoan(
            @PathVariable Integer id,
            @RequestBody LoanUpdateDto loanUpdateDto) {
        return ResponseEntity.ok(loanServiceImpl.updateLoan(id, loanUpdateDto));
    }

    // Loan silme
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLoan(@PathVariable Integer id) {
        loanServiceImpl.deleteLoan(id);
        return ResponseEntity.ok("Loan kaydı silindi. ID: " + id);
    }
}

