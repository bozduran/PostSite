package com.bozduran.site.repository;

import com.bozduran.site.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AccountRepository extends JpaRepository<Account, UUID> {
    boolean existsAccountByEmail(String email);
    Account getAccountByAccountCredentials_UserName(String accountCredentials_userName);
    Account getAccountById(UUID id);
}
