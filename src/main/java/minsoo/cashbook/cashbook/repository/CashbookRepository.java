package minsoo.cashbook.cashbook.repository;

import minsoo.cashbook.cashbook.domain.Cashbook;

import java.util.List;

public interface CashbookRepository {

    void save(Cashbook cashbook);
    List<Cashbook> findByMonth(String month);
    List<Cashbook> findAll();
}
