package minsoo.cashbook.repository;

import lombok.extern.slf4j.Slf4j;
import minsoo.cashbook.domain.Account;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@Slf4j
public class MemoryAccountRepositoryTest {

    MemoryAccountRepository repository = new MemoryAccountRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        // given
        Account account = new Account();
        account.setDate("06/20");

        // when
        repository.save(account);

        // then
        Account result = repository.findById(account.getId()).get();
        assertThat(result).isEqualTo(account);
    }

    @Test
    public void findByDate() {
        // given
        Account account1 = new Account();
        account1.setDate("06/20");
        repository.save(account1);

        Account account2 = new Account();
        account2.setDate("06/20");
        repository.save(account2);

        Account account3 = new Account();
        account3.setDate("06/21");
        repository.save(account3);

        // when
        List<Account> result = repository.findByDate("06/20");

        // then
        assertThat(result.size()).isEqualTo(2);
        log.info("result = {}", result);
    }
}
