package ru.be_prog.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.be_prog.model.Account;
import ru.be_prog.service.AccountService;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @ModelAttribute("allAccounts")
    public List<Account> allAccounts() {
        return accountService.findAllAccounts();
    }

    @GetMapping(value = "/accounts")
    public String accountsView(Model model) {
        model.addAttribute("newAccount", new Account());
        return "accounts";
    }

    @PostMapping(value = "/accounts")
    public String createAccount(Model model, @ModelAttribute Account newAccount) {
        newAccount.setId(UUID.randomUUID());
        accountService.saveAccount(newAccount);
        model.addAttribute("newAccount", new Account());
        return "redirect:/accounts";
    }

}
