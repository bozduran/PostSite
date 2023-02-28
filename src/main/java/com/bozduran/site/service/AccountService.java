package com.bozduran.site.service;

import com.bozduran.site.data.Account;
import com.bozduran.site.repository.AccountCredentialsRepository;
import com.bozduran.site.repository.AccountRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {


    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AccountCredentialsRepository accountCredentialsRepository;

    public List<Account> getAllPersons() {
        return (List<Account>) accountRepository.findAll();
    }

    public void addPerson(Account account) {
        accountRepository.save(account);
        accountCredentialsRepository.save(account.getAccountCredentials());
    }

}