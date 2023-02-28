package com.bozduran.site.service;

import com.bozduran.site.data.Account;
import com.bozduran.site.repository.AccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AccountService {

    AccountRepository accountRepository;

    @Transactional
    public List<Account> getAllPersons() {
        return (List<Account>) accountRepository.findAll();
    }


    @Transactional
    public void addPerson(Account account) {
        accountRepository.save(account);
    }

}