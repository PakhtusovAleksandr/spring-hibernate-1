package ru.be_prog.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.be_prog.dao.AccountDao;
import ru.be_prog.model.Account;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountDao accountDao;

    @Override
    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    @Override
    @Transactional
    public void updateAccount(Account account) {
        accountDao.findAccountById(account.getId());
        accountDao.saveAccount(account);
    }

    @Override
    public Account findAccountById(UUID id) {
        return accountDao.findAccountById(id);
    }

    @Override
    public List<Account> findAllAccounts() {
        return accountDao.findAllAccounts();
    }

    @Override
    public void deleteAccountById(UUID id) {
        accountDao.deleteAccountById(id);
    }

    @Override
    public void deleteAllAccounts() {
        accountDao.deleteAllAccounts();
    }

    @Override
    public List<Account> findAccountByCountry(String country) {
        return accountDao.findAccountByCountry(country);
    }
}
