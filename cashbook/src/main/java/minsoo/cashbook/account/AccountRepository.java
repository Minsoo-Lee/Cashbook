package minsoo.cashbook.account;

public interface AccountRepository {

    void save(Account account);
    Account findById(Long accountId);
}
