package minsoo.cashbook.account;

import java.util.HashMap;
import java.util.Map;

public class MemoryAccountRepository implements AccountRepository {

    private static Map<Long, Account> store = new HashMap<>();

    @Override
    public void save(Account account) {
        store.put(account.getId(), account);
    }

    @Override
    public Account findById(Long accountId) {
        return store.get(accountId);
    }
}
