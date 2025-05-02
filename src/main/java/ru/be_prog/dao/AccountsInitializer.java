package ru.be_prog.dao;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import ru.be_prog.model.Account;
import ru.be_prog.model.Profile;
import ru.be_prog.repository.AccountRepository;
import ru.be_prog.service.AccountService;

import java.time.LocalDate;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class AccountsInitializer {
    private final AccountService accountService;
    private final PlatformTransactionManager transactionManager;

    @PostConstruct
    public void init() {
        TransactionTemplate transactionTemplate = new TransactionTemplate(transactionManager);
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                accountService.deleteAllAccounts();
                createAccounts();
            }
        });
    }

    private void createAccounts() {
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

