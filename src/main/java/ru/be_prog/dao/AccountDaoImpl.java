package ru.be_prog.dao;

import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.hibernate.query.MutationQuery;
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
        MutationQuery query = sessionFactory.getCurrentSession().createMutationQuery("delete from Account");
        query.executeUpdate();
    }
}
