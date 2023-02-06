package minsoo.cashbook.cashbook.controller;

import minsoo.cashbook.cashbook.domain.Cashbook;
import minsoo.cashbook.cashbook.service.CashbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CashbookController {

    public final CashbookService cashbookService;

    @Autowired
    public CashbookController(CashbookService cashbookService) {
        this.cashbookService = cashbookService;
    }

    @GetMapping("/")
    public String home() { return "home"; }

    @GetMapping("/cashbook/new")
    public String createForm() { return "cashbook/createForm"; }

    @PostMapping("/cashbook/new")
    public String create(Cashbook cashbook) {
        cashbookService.join(cashbook);
        return "redirect:/";
    }

    @GetMapping("/cashbook/check")
    public String check(Model model) {
        model.addAttribute("cashbookList", cashbookService.findAll());
        return "cashbook/checkList";
    }
}
