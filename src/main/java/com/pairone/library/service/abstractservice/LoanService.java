package com.pairone.library.service.abstractservice;

import com.pairone.library.dto.loan.*;
import com.pairone.library.entity.Loan;

import java.util.List;

public interface LoanService {
    Loan entityLoanById(Integer id);
    String deleteLoan(Integer id);
    LoanResponseDto updateLoan(Integer id, LoanUpdateDto dto);
    LoanResponseDto getLoanById(int id);
    List<LoanListDto> getAllLoans();
    LoanCreateResponseDto createLoan(LoanCreateDto dto);
}
