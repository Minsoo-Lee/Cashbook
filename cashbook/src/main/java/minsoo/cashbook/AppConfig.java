package minsoo.cashbook;

import minsoo.cashbook.repository.AccountRepository;
import minsoo.cashbook.repository.JpaAccountRepository;
import minsoo.cashbook.repository.MemoryAccountRepository;
import minsoo.cashbook.service.AccountService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class AppConfig {

    private final DataSource dataSource;
    private final EntityManager em;

    public AppConfig(DataSource dataSource, EntityManager em) {
        this.dataSource = dataSource;
        this.em = em;
    }

    @Bean
    public AccountService accountService() {
        return new AccountService(accountRepository());
    }

    @Bean
    public AccountRepository accountRepository() {
        return new JpaAccountRepository(em);
    }
}
