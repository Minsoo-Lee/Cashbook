package minsoo.cashbook.repository;

import minsoo.cashbook.domain.Account;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaAccountRepository implements AccountRepository {

    private final EntityManager em;

    public JpaAccountRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Account save(Account account) {
        em.persist(account);
        return account;
    }

    @Override
    public Optional<Account> findById(Long id) {
        Account account = em.find(Account.class, id);
        return Optional.ofNullable(account);
    }

    @Override
    public List<Account> findByDate(String date) {
        return em.createQuery("select m from Account m where m.date = :date", Account.class)
                .setParameter("date", date)
                .getResultList();
    }

    @Override
    public List<Account> findAll() {
        return em.createQuery("select m from Account m", Account.class)
                .getResultList();
    }
}
