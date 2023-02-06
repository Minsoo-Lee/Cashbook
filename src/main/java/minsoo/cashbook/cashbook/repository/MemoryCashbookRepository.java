package minsoo.cashbook.cashbook.repository;

import minsoo.cashbook.cashbook.domain.Cashbook;

import java.util.ArrayList;
import java.util.List;

public class MemoryCashbookRepository implements CashbookRepository {
    List<Cashbook> cashbookList = new ArrayList<>();

    @Override
    public void save(Cashbook cashbook) {

    }

    @Override
    public void findByMonth(String month) {

    }

    @Override
    public void findAll(String month) {

    }
}
