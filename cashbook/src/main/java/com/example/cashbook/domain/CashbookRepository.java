package com.example.cashbook.domain;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CashbookRepository {

    private static final Map<Long, Cashbook> store = new HashMap<>();
    private static long sequence = 0L;

    public Cashbook save(Cashbook cashbook) {
        cashbook.setId(++sequence);
        store.put(cashbook.getId(), cashbook);
        return cashbook;
    }

    public Cashbook findById(Long id) {
        return store.get(id);
    }

    public List<Cashbook> findByAll() {
        return new ArrayList<>(store.values());
    }

    public void update(Long id, Cashbook cashbook) {
        Cashbook find = store.get(id);
        find.setDate(cashbook.getDate());
        find.setContent(cashbook.getContent());
        find.setType(cashbook.getType());
        find.setExpense(cashbook.getExpense());
        find.setIncome(cashbook.getIncome());
        find.setBalance(cashbook.getBalance());
    }

    public void clearStore() {
        store.clear();
    }
}
