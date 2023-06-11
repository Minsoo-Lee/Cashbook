package minsoo.cashbook.repository;

import minsoo.cashbook.domain.Account;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class MemoryAccountRepository implements AccountRepository {

    private static Map<Long, Account> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Account save(Account account) {
        account.setId(++sequence);
        store.put(account.getId(), account);
        return account;
    }

    @Override
    public Optional<Account> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<Account> findByDate(String date) {
        return store.values().stream()
                .filter(account -> account.getDate().equals(date))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public List<Account> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
