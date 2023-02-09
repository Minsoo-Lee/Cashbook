package minsoo.cashbook.cashbook.repository;

import minsoo.cashbook.cashbook.domain.Cashbook;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryCashbookRepository implements CashbookRepository {

    private static Map<Long, Cashbook> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Cashbook save(Cashbook cashbook) {
        cashbook.setId(++sequence);
        store.put(cashbook.getId(), cashbook);
        return cashbook;
    }

    @Override
    public Optional<Cashbook> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<Cashbook> findByMonth(String month) {
        List<Cashbook> result = new ArrayList<>();
        for (Cashbook cashbook : store.values()) {
            if (cashbook.getDate().split("-")[1].equals(month))
                result.add(cashbook);
        }
        return result;
    }

    @Override
    public List<Cashbook> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearAll() {
        store.clear();
    }

    public int getSize() {
        return store.size();
    }
}