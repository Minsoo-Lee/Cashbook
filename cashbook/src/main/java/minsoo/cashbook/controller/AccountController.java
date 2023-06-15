package minsoo.cashbook.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import minsoo.cashbook.domain.Account;
import minsoo.cashbook.repository.AccountRepository;
import minsoo.cashbook.validator.AccountValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/basic/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountRepository accountRepository;
    private final AccountValidator accountValidator;

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
    public String addForm(Model model) {
        model.addAttribute("account", new Account());
        return "basic/addForm";
    }

    @PostMapping("/add")
    public String addAccountV5(@ModelAttribute Account account, RedirectAttributes redirectAttributes,
                               BindingResult bindingResult) {

        accountValidator.validate(account, bindingResult);

        // 검증에 실패하면 다시 입력 폼으로
        if (bindingResult.hasErrors()) {
            log.info("errors={}", bindingResult);
            return "basic/addForm";
        }

        // 성공 로직
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
