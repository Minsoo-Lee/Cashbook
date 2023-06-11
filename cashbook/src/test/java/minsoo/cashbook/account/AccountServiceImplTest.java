package minsoo.cashbook.account;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountServiceImplTest {

    AccountService accountService = new AccountServiceImpl();

    @Test
    void join() {
        // given
        Account account = new Account(1L, "10/26", "edu", "42seoul", 100, 200, 100);

        // when
        accountService.join(account);
        Account findAccount = accountService.findAccount(1L);

        // then
        Assertions.assertThat(account).isEqualTo(findAccount);
    }

    @Test
    void findAccount() {
    }
}