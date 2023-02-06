package minsoo.cashbook.cashbook.service;

import minsoo.cashbook.cashbook.domain.Cashbook;
import minsoo.cashbook.cashbook.repository.CashbookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CashbookService {

    private final CashbookRepository cashbookRepository;

    @Autowired
    public CashbookService(CashbookRepository cashbookRepository) {
        this.cashbookRepository = cashbookRepository;
    }

    public void join(Cashbook cashbook) {
        cashbookRepository.save(cashbook);
    }
}
