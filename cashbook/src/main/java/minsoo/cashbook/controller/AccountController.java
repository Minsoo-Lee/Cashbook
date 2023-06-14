package minsoo.cashbook.controller;

import lombok.RequiredArgsConstructor;
import minsoo.cashbook.domain.Account;
import minsoo.cashbook.repository.AccountRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
@RequestMapping("/basic/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountRepository accountRepository;

    @GetMapping
    public String accounts(Model model) {
        List<Account> accounts = accountRepository.findAll();
        model.addAttribute("accounts", accounts);
        return "basic/accounts";
    }

    @GetMapping("/{id}")
    public String account(@PathVariable Long id, Model model) {
        Account account = accountRepository.findById(id);
        model.addAttribute("account", account);
        return "basic/account";
    }

    @GetMapping("/add")
    public String addForm() {
        return "basic/addForm";
    }

    //@PostMapping("/add")
    public String addAccountV1(@RequestParam String date,
                            @RequestParam String type,
                            @RequestParam String content,
                            @RequestParam Integer expend,
                            @RequestParam Integer income,
                            @RequestParam Integer balance,
                            Model model) {
        Account account = new Account("06/20", "eat", "house", 100, 1000, 900);
        accountRepository.save(account);
        model.addAttribute("account", account);
        return "basic/account";
    }

    //@PostMapping("/add")
    public String addAccountV2(@ModelAttribute("account") Account account, Model model) {
        accountRepository.save(account);
        return "basic/account";
    }

    //@PostMapping("/add")
    public String addAccountV3(@ModelAttribute Account account) {
        accountRepository.save(account);
        return "basic/account";
    }

    //@PostMapping("/add")
    public String addAccountV4(Account account) {
        accountRepository.save(account);
        return "basic/account";
    }

    //@PostMapping("/add")
    public String addAccountV5(Account account) {
        accountRepository.save(account);
        return "redirect:/basic/accounts/" + account.getId();
    }

    @PostMapping("/add")
    public String addAccountV6(Account account, RedirectAttributes redirectAttributes) {
        Account savedAccount = accountRepository.save(account);
        redirectAttributes.addAttribute("id", savedAccount.getId());
        redirectAttributes.addAttribute("status", true);
        return "redirect:/basic/accounts/{id}";
    }

    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        Account account = accountRepository.findById(id);
        model.addAttribute("account", account);
        return "basic/editForm";
    }

    @PostMapping("/{id}/edit")
    public String edit(@PathVariable Long id, @ModelAttribute Account account) {
        accountRepository.update(id, account);
        return "redirect:/basic/accounts/{id}";
    }

    /**
     * 테스트용 데이터 추가
     */
    @PostConstruct
    public void init() {
        accountRepository.save(new Account("06/20", "eat", "house", 100, 1000, 900));
        accountRepository.save(new Account("06/20", "eat", "house", 100, 2000, 1900));
    }
}
