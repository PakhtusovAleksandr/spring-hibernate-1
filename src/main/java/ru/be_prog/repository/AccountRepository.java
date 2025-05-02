package ru.be_prog.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.be_prog.model.Account;

import java.util.List;
import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, UUID> {

    @EntityGraph(attributePaths = "profile")
    @Query("SELECT a FROM Account a WHERE a.profile.country = :country")
    List<Account> findAccountByCountry(@Param("country") String country);

}
