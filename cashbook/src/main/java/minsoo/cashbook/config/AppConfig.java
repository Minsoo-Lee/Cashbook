package minsoo.cashbook.config;

import minsoo.cashbook.account.AccountRepository;
import minsoo.cashbook.account.AccountService;
import minsoo.cashbook.account.AccountServiceImpl;
import minsoo.cashbook.account.MemoryAccountRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public AccountService accountService() {
        return new AccountServiceImpl(new MemoryAccountRepository());
    }

    @Bean
    public AccountRepository accountRepository() {
        return new MemoryAccountRepository();
    }
}
