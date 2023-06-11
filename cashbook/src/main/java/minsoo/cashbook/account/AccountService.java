package minsoo.cashbook.account;

public interface AccountService {

    void join(Account account);
    Account findAccount(Long accountId);

}
