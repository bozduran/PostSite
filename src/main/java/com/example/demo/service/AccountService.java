package com.example.demo.service;

import com.example.demo.data.Account;
import com.example.demo.repository.AccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AccountService {

    @Autowired
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