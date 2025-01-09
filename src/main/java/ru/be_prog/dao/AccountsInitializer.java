package ru.be_prog.dao;

import org.springframework.stereotype.Component;
import ru.be_prog.model.Account;
import ru.be_prog.service.AccountService;

import java.util.UUID;

@Component
public class AccountsInitializer {

    public AccountsInitializer(AccountService accountService) {
        accountService.deleteAllAccounts();

        Account account1 = new Account(UUID.randomUUID(), "Steve", "Jobs");
        accountService.saveAccount(account1);

        Account account2 = new Account(UUID.randomUUID(), "Bill", "Gates");
        accountService.saveAccount(account2);

        Account account3 = new Account(UUID.randomUUID(), "James", "Gosling");
        accountService.saveAccount(account3);

        Account account4 = new Account(UUID.randomUUID(), "Erich", "Gamma");
        accountService.saveAccount(account4);
    }
}

