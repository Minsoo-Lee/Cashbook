package minsoo.cashbook.repository;

import minsoo.cashbook.domain.Account;

import java.util.List;
import java.util.Optional;

public interface AccountRepository {

    Account save(Account account);
    Optional<Account> findById(Long id);
    List<Account> findByDate(String date);
    List<Account> findAll();
}
