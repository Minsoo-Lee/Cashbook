package minsoo.cashbook;

import minsoo.cashbook.account.Account;
import minsoo.cashbook.account.AccountService;
import minsoo.cashbook.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CashbookApp {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
        Account account = new Account(1L, "10/26", "edu", "42seoul", 100, 200, 100);
        accountService.join(account);

        Account findAccount = accountService.findAccount(account.getId());
        System.out.println("new member = " + account);
        System.out.println("find member = " + findAccount);
    }
}
