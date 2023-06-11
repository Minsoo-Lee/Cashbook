package minsoo.cashbook.account;

public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void join(Account account) {
        accountRepository.save(account);
    }

    @Override
    public Account findAccount(Long accountId) {
        return accountRepository.findById(accountId);
    }
}
