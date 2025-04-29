package ru.be_prog.dao;

import org.springframework.stereotype.Component;
import ru.be_prog.model.Account;
import ru.be_prog.model.Profile;
import ru.be_prog.service.AccountService;

import java.time.LocalDate;
import java.util.UUID;

@Component
public class AccountsInitializer {

    public AccountsInitializer(AccountService accountService) {
        accountService.deleteAllAccounts();

        Profile profile1 = new Profile(LocalDate.of(2022, 4, 11), "Russia", "Loh1");
        Account account1 = new Account(UUID.randomUUID(), "Steve", "Jobs", profile1);
        accountService.saveAccount(account1);

        Profile profile2 = new Profile(LocalDate.of(2021, 4, 23), "USA", "Loh2");
        Account account2 = new Account(UUID.randomUUID(), "Bill", "Gates", profile2);
        accountService.saveAccount(account2);

        Profile profile3 = new Profile(LocalDate.of(2021, 11, 13), "Japan", "Loh3");
        Account account3 = new Account(UUID.randomUUID(), "James", "Gosling", profile3);
        accountService.saveAccount(account3);

        Profile profile4 = new Profile(LocalDate.of(2022, 4, 1), "Russia", "Loh4");
        Account account4 = new Account(UUID.randomUUID(), "Erich", "Gamma", profile4);
        accountService.saveAccount(account4);
    }
}

