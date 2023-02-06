package minsoo.cashbook.cashbook.repository;

import minsoo.cashbook.cashbook.domain.Cashbook;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MemoryCashbookRepository implements CashbookRepository {
    List<Cashbook> cashbookList = new ArrayList<>();

    @Override
    public void save(Cashbook cashbook) {
        cashbookList.add(cashbook);
    }

    @Override
    public List<Cashbook> findByMonth(String month) {
        List<Cashbook> result = new ArrayList<>();
        for (Cashbook cashbook : cashbookList) {
            if (cashbook.getDate().contains(month))
                result.add(cashbook);
        }
        return result;
    }

    @Override
    public List<Cashbook> findAll(String month) {
        return cashbookList;
    }
}
