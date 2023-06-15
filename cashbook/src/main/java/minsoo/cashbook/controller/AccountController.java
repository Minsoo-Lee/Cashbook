package minsoo.cashbook.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import minsoo.cashbook.domain.Account;
import minsoo.cashbook.repository.AccountRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
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

    //@PostMapping("/add")
    public String addAccount(@ModelAttribute Account account, RedirectAttributes redirectAttributes,
                               Model model) {
        // 검증 오류 결과를 보관
        Map<String, String> errors = new HashMap<>();

        // 검증 로직
        putErrors(account, errors);

        // 검증에 실패하면 다시 입력 폼으로
        if (!errors.isEmpty()) {
            model.addAttribute("errors", errors);
            return "basic/addForm";
        }

        // 성공 로직
        Account savedAccount = accountRepository.save(account);
        redirectAttributes.addAttribute("id", savedAccount.getId());
        redirectAttributes.addAttribute("status", true);
        return "redirect:/basic/accounts/{id}";
    }

    private static void putErrors(Account account, Map<String, String> errors) {
        if (!StringUtils.hasText(account.getDate()))
            errors.put("date", "날짜는 필수입니다.");
        if (!StringUtils.hasText(account.getType()))
            errors.put("type", "타입은 필수입니다.");
        if (!StringUtils.hasText(account.getContent()))
            errors.put("content", "내용은 필수입니다.");
        if (account.getExpend() == null || account.getExpend() < 0)
            errors.put("expend", "지출은 양의 정수만 허용합니다.");
        if (account.getIncome() == null || account.getIncome() < 0)
            errors.put("income", "수입은 양의 정수만 허용합니다.");
        if (account.getBalance() == null || account.getBalance() < 0)
            errors.put("balance", "잔액은 양의 정수만 허용합니다.");
    }

    //@PostMapping("/add")
    public String addAccountV1(@ModelAttribute Account account, RedirectAttributes redirectAttributes,
                               BindingResult bindingResult) {
        // 검증 로직
        putErrorsV1(account, bindingResult);

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

    private static void putErrorsV1(Account account, BindingResult bindingResult) {
        if (!StringUtils.hasText(account.getDate()))
            bindingResult.addError(new FieldError("account", "date", "날짜는 필수입니다."));
        if (!StringUtils.hasText(account.getType()))
            bindingResult.addError(new FieldError("account", "type", "타입은 필수입니다."));
        if (!StringUtils.hasText(account.getContent()))
            bindingResult.addError(new FieldError("account", "content", "내용은 필수입니다."));
        if (account.getExpend() == null || account.getExpend() < 0)
            bindingResult.addError(new FieldError("account", "expend", "지출은 양의 정수만 허용합니다."));
        if (account.getIncome() == null || account.getIncome() < 0)
            bindingResult.addError(new FieldError("account", "income", "수입은 양의 정수만 허용합니다."));
        if (account.getBalance() == null || account.getBalance() < 0)
            bindingResult.addError(new FieldError("account", "balance", "잔액은 양의 정수만 허용합니다."));
    }

    //@PostMapping("/add")
    public String addAccountV2(@ModelAttribute Account account, RedirectAttributes redirectAttributes,
                               BindingResult bindingResult) {
        // 검증 로직
        putErrorsV2(account, bindingResult);

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

    private static void putErrorsV2(Account account, BindingResult bindingResult) {
        if (!StringUtils.hasText(account.getDate()))
            bindingResult.addError(new FieldError("account", "date", account.getDate(), false, null, null, "날짜는 필수입니다."));
        if (!StringUtils.hasText(account.getType()))
            bindingResult.addError(new FieldError("account", "type", account.getType(), false, null, null, "타입은 필수입니다."));
        if (!StringUtils.hasText(account.getContent()))
            bindingResult.addError(new FieldError("account", "content", account.getContent(), false, null, null, "내용은 필수입니다."));
        if (account.getExpend() == null || account.getExpend() < 0)
            bindingResult.addError(new FieldError("account", "expend", account.getExpend(), false, null, null, "지출은 양의 정수만 허용합니다."));
        if (account.getIncome() == null || account.getIncome() < 0)
            bindingResult.addError(new FieldError("account", "income", account.getIncome(), false, null, null, "수입은 양의 정수만 허용합니다."));
        if (account.getBalance() == null || account.getBalance() < 0)
            bindingResult.addError(new FieldError("account", "balance", account.getBalance(), false, null, null, "잔액은 양의 정수만 허용합니다."));
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
