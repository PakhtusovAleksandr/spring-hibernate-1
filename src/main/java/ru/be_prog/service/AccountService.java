package ru.be_prog.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.be_prog.model.Account;
import ru.be_prog.repository.AccountRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    @Transactional
    public void saveAccount(Account account) {
        accountRepository.save(account);
    }

    @Transactional
    public void updateAccount(Account account) {
        accountRepository.findById(account.getId());
        accountRepository.save(account);
    }

    @Transactional
    public Optional<Account> findAccountById(UUID id) {
        return accountRepository.findById(id);
    }

    @Transactional
    public List<Account> findAllAccounts() {
        return accountRepository.findAll();
    }

    @Transactional
    public void deleteAccountById(UUID id) {
        accountRepository.deleteById(id);
    }

    @Transactional
    public void deleteAllAccounts() {
        accountRepository.deleteAll();
    }

    @Transactional
    public List<Account> findAccountByCountry(String country) {
        return accountRepository.findAccountByCountry(country);
    }
}
