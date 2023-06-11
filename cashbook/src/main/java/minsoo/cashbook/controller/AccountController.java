package minsoo.cashbook.controller;

import minsoo.cashbook.domain.Account;
import minsoo.cashbook.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping(value = "/accounts/new")
    public String createForm() {
        return "accounts/createAccountForm";
    }

    @PostMapping(value = "/accounts/new")
    public String create(AccountForm form) {

        Account account = new Account();
        account.setDate(form.getDate());
        account.setType(form.getType());
        account.setContent(form.getContent());
        account.setExpend(form.getExpend());
        account.setIncome(form.getIncome());
        account.setBalance(form.getBalance());

        accountService.join(account);

        return "redirect:/";
    }

    @GetMapping(value = "/accounts")
    public String list(Model model) {
        List<Account> accounts = accountService.findAccounts();
        model.addAttribute("accounts", accounts);
        return "accounts/accountList";
    }
}
