package com.bozduran.site.repository;

import com.bozduran.site.domain.Account;
import com.bozduran.site.domain.AccountCredentials;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account,Long> {
    boolean existsAccountByEmail(String email);
    Account getAccountByAccountCredentials_UserName(String accountCredentials_userName);
    Account getAccountByAccountId(Long id);
}
