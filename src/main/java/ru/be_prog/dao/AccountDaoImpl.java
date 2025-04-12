package ru.be_prog.dao;

import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.be_prog.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.be_prog.model.Account;

import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
@Transactional
public class AccountDaoImpl implements AccountDao {

    private final SessionFactory sessionFactory;

    @Override
    public void saveAccount(Account account) {
        sessionFactory.getCurrentSession().persist(account);
    }

    @Override
    public Account findAccountById(UUID id) {
        Account account = sessionFactory.getCurrentSession().find(Account.class, id);
        if (account == null) {
            throw new NotFoundException(String.format("Account not found id=%s", id));
        }
        return account;
    }

    @Override
    public List<Account> findAllAccounts() {
        TypedQuery<Account> query = sessionFactory.getCurrentSession().createQuery("from Account", Account.class);
        return query.getResultList();
    }

    @Override
    public void deleteAccountById(UUID id) {
        Account account = findAccountById(id);
        sessionFactory.getCurrentSession().remove(account);
    }

    @Override
    public void deleteAllAccounts() {
        List<Account> accounts = findAllAccounts();
        Session session = sessionFactory.getCurrentSession();
        for (Account account: accounts) {
            session.remove(account);
        }
    }


    @Override
    public List<Account> findAccountByCountry(String country) {
        TypedQuery<Account> query = sessionFactory.getCurrentSession().createQuery("SELECT account FROM Account account WHERE account.profile.country = :country", Account.class);
        query.setParameter("country", country);
        return query.getResultList();

    }


}
