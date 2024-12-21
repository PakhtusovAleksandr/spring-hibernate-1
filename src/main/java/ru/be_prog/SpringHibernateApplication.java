package ru.be_prog;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.be_prog.configuration.HibernateConfiguration;
import ru.be_prog.model.Account;
import ru.be_prog.service.AccountService;

import java.util.List;
import java.util.UUID;

public class SpringHibernateApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfiguration.class);

        AccountService accountService = context.getBean(AccountService.class);

        // Сначала мы очищаем таблицу аккаунтов
        accountService.deleteAllAccounts();

        // Создаем 4 аккаунта
        Account account1 = new Account(UUID.randomUUID(), "Steve", "Jobs");
        accountService.saveAccount(account1);

        Account account2 = new Account(UUID.randomUUID(), "Bill", "Gates");
        accountService.saveAccount(account2);

        Account account3 = new Account(UUID.randomUUID(), "James", "Gosling");
        accountService.saveAccount(account3);

        Account account4 = new Account(UUID.randomUUID(), "Erich", "Gamma");
        accountService.saveAccount(account4);

        // Получаем все аккаунты из базы и выводим на экран
        List<Account> allAccounts = accountService.findAllAccounts();
        for (Account account: allAccounts) {
            System.out.println(account);
        }
    }
}
