package minsoo.cashbook.cashbook.controller;

import minsoo.cashbook.cashbook.service.CashbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
}
