package com.example.cashbook.controller;

import com.example.cashbook.domain.Cashbook;
import com.example.cashbook.domain.CashbookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.PostConstruct;
import java.util.List;

@RequestMapping("/basic/cashbook")
@Controller
@RequiredArgsConstructor
@Slf4j
public class BasicCashbookController {

    private final CashbookRepository repository;

    @GetMapping
    public String cashbooks(Model model) {
        List<Cashbook> cashbooks = repository.findByAll();
        model.addAttribute("cashbooks", cashbooks);
        return "basic/cashbooks";
    }

    @GetMapping("/{id}")
    public String item(@PathVariable Long id, Model model) {
        Cashbook cashbook = repository.findById(id);
        log.info("[cashbook] {}", cashbook);
        model.addAttribute("cashbook", cashbook);
        return "basic/cashbook";
    }

    @GetMapping("/add")
    public String add(){
        return "basic/addForm";
    }

    @PostMapping("/add")
    public String addCashbook(@ModelAttribute Cashbook cashbook, RedirectAttributes redirectAttributes) {
        Cashbook savedCashbook = repository.save(cashbook);
        redirectAttributes.addAttribute("id", savedCashbook.getId());
        redirectAttributes.addAttribute("status", true);
        return "redirect:/basic/cashbook/" + cashbook.getId();
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        Cashbook cashbook = repository.findById(id);
        model.addAttribute("cashbook", cashbook);
        return "basic/editForm";
    }

    @PostMapping("/{id}/edit")
    public String editCashbook(@PathVariable Long id, @ModelAttribute Cashbook cashbook) {
        repository.update(id, cashbook);
        return "redirect:/basic/cashbook/{id}";
    }

    @PostConstruct
    public void init() {
        repository.save(new Cashbook("0000-01-01", "Type", "Content", null, null, 0));
    }
}
