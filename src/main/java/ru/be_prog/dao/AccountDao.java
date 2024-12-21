package ru.be_prog.dao;

import ru.be_prog.model.Account;

import java.util.List;
import java.util.UUID;

public interface AccountDao {
    void saveAccount(Account account);

    Account findAccountById(UUID id);

    List<Account> findAllAccounts();

    void deleteAccountById(UUID id);

    void deleteAllAccounts();
}
