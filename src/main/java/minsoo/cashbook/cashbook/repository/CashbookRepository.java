package minsoo.cashbook.cashbook.repository;

import minsoo.cashbook.cashbook.domain.Cashbook;

import java.util.List;
import java.util.Optional;

public interface CashbookRepository {

    Cashbook save(Cashbook cashbook);
    Optional<Cashbook> findById(Long id);
    Optional<Cashbook> findByMonth(String month);
    List<Cashbook> findAll();
}
