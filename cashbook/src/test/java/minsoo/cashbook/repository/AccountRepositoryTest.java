package minsoo.cashbook.repository;

import lombok.extern.slf4j.Slf4j;
import minsoo.cashbook.domain.Account;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@Slf4j
public class AccountRepositoryTest {

    AccountRepository repository = new AccountRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    void save() {
        // given
        Account account = new Account("06/20", "eat", "house", 100, 1000, 900);

        // when
        Account savedAccount = repository.save(account);

        // then
        Account findAccount = repository.findById(account.getId());
        assertThat(findAccount).isEqualTo(savedAccount);
    }

    @Test
    void findAll() {
        // given
        Account account1 = new Account("06/20", "eat", "house", 100, 1000, 900);
        Account account2 = new Account("06/20", "eat", "house", 100, 2000, 1900);

        repository.save(account1);
        repository.save(account2);

        // when
        List<Account> result = repository.findAll();

        // then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(account1, account2);
    }

    @Test
    void updateItem() {
        Account account = new Account("06/20", "eat", "house", 100, 1000, 900);

        Account savedAccount = repository.save(account);
        Long accountId = savedAccount.getId();

        // when
        Account updateParam = new Account("06/20", "eat", "house", 100, 2000, 1900);
        repository.update(accountId, updateParam);

        Account findAccount = repository.findById(accountId);

        // then
        assertThat(findAccount.getDate()).isEqualTo(updateParam.getDate());
        assertThat(findAccount.getType()).isEqualTo(updateParam.getType());
        assertThat(findAccount.getContent()).isEqualTo(updateParam.getContent());
        assertThat(findAccount.getExpend()).isEqualTo(updateParam.getExpend());
        assertThat(findAccount.getIncome()).isEqualTo(updateParam.getIncome());
        assertThat(findAccount.getBalance()).isEqualTo(updateParam.getBalance());
    }
}
