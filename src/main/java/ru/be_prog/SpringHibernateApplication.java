package ru.be_prog;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.be_prog.configuration.HibernateConfiguration;
import ru.be_prog.dao.AccountDaoImpl;
import ru.be_prog.model.Account;
import ru.be_prog.model.Profile;
import ru.be_prog.service.AccountService;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class SpringHibernateApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfiguration.class);

        AccountService accountService = context.getBean(AccountService.class);

        // Сначала мы очищаем таблицу аккаунтов
        accountService.deleteAllAccounts();

        // Создаем 4 аккаунта и профили для них
        Account account1 = new Account(UUID.randomUUID(), "Steve", "Jobs",null);
        Profile profile1 = new Profile(account1.getId(),LocalDate.of(2022, 4,11),"Russia","Loh1",account1);
        account1.setProfile(profile1);
        accountService.saveAccount(account1);

        Account account2 = new Account(UUID.randomUUID(), "Bill", "Gates",null);
        Profile profile2 = new Profile(account2.getId(),LocalDate.of(2021, 4,23),"USA","Loh2",account2);
        account2.setProfile(profile2);
        accountService.saveAccount(account2);

        Account account3 = new Account(UUID.randomUUID(), "James", "Gosling",null);
        Profile profile3 = new Profile(account3.getId(),LocalDate.of(2021, 11,13),"Japan","Loh3",account3);
        account3.setProfile(profile3);
        accountService.saveAccount(account3);

        Account account4 = new Account(UUID.randomUUID(), "Erich", "Gamma", null);
        Profile profile4 = new Profile(account4.getId(),LocalDate.of(2022, 4,1),"Russia","Loh4",account4);
        account4.setProfile(profile4);
        accountService.saveAccount(account4);

        // Получаем все аккаунты из базы и выводим на экран
        List<Account> allAccounts = accountService.findAllAccounts();
        for (Account account: allAccounts) {
            System.out.println(account);
        }
        List<Account> allAccountsWithCountry = accountService.findAccountByCountry("Russia");
        for (Account account: allAccountsWithCountry) {
            System.out.println(account);
        }
    }
}
