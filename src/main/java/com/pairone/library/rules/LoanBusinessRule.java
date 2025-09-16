import com.pairone.library.entity.Loan;
import com.pairone.library.repository.LoanRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

@Component
public class LoanBusinessRule {
    private final LoanRepository loanRepository;

    public LoanBusinessRule(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public Loan findLoanIsExists(Integer id) {
        return loanRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Loan bulunamadı: " + id));
    }
}