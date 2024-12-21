package ru.be_prog.service;

import ru.be_prog.model.Account;

import java.util.List;
import java.util.UUID;

public interface AccountService {

    void saveAccount(Account account);

    void updateAccount(Account account);

    Account findAccountById(UUID id);

    List<Account> findAllAccounts();

    void deleteAccountById(UUID id);

    void deleteAllAccounts();
}
