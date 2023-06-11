package minsoo.cashbook.service;

import minsoo.cashbook.domain.Account;
import minsoo.cashbook.repository.MemoryAccountRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AccountServiceTest {

    AccountService accountService;
    MemoryAccountRepository accountRepository;

    @BeforeEach
    public void beforeEach() {
        accountRepository = new MemoryAccountRepository();
        accountService = new AccountService(accountRepository);
    }

    @AfterEach
    public void afterEach() {
        accountRepository.clearStore();
    }

    @Test
    public void 회원가입() throws Exception {
        // given
        Account account = new Account();
        account.setDate("06/20");

        // when
        Long saveId = accountService.join(account);

        // then
        Account findAccount = accountRepository.findById(saveId).get();
        Assertions.assertEquals(account.getDate(), account.getDate());
    }
}
