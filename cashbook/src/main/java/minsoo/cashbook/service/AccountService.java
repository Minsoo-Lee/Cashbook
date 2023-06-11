package minsoo.cashbook.service;

import minsoo.cashbook.domain.Account;
import minsoo.cashbook.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    /**
     * 회원가입
     * @param account
     * @return
     */
    public Long join(Account account) {
        accountRepository.save(account);
        return account.getId();
    }

    /**
     * 전체 회원 조회
     * @return
     */
    public List<Account> findAccounts() {
        return accountRepository.findAll();
    }

    public Optional<Account> findOne(Long accountId) {
        return accountRepository.findById(accountId);
    }

}
