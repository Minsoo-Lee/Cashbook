package minsoo.cashbook.repository;

import minsoo.cashbook.domain.Account;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class AccountRepository {

    private static final Map<Long, Account> store = new HashMap<>();
    private static long sequence = 0L;

    public Account save(Account account) {
        account.setId(++sequence);
        store.put(account.getId(), account);
        return account;
    }

    public Account findById(Long id) {
        return store.get(id);
    }

    public List<Account> findAll() {
        return new ArrayList<>(store.values());
    }

    public void update(Long accountId, Account updateParam) {
        Account findAccount = findById(accountId);
        findAccount.setDate(updateParam.getDate());
        findAccount.setType(updateParam.getType());
        findAccount.setContent(updateParam.getContent());
        findAccount.setExpend(updateParam.getExpend());
        findAccount.setIncome(updateParam.getIncome());
        findAccount.setBalance(updateParam.getBalance());
    }

    public void clearStore() {
        store.clear();
    }
}
