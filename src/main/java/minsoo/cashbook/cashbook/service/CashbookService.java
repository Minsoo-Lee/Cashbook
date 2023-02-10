package minsoo.cashbook.cashbook.service;

import minsoo.cashbook.cashbook.domain.Cashbook;
import minsoo.cashbook.cashbook.repository.CashbookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Cashbook> findOne(Long id) { return cashbookRepository.findById(id); }
    public List<Cashbook> findAll() {
        return cashbookRepository.findAll();
    }
    public List<Cashbook> findMonth(String month) {
        return cashbookRepository.findByMonth(month);
    }
}
