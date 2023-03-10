package com.bozduran.site.service;

import com.bozduran.site.model.AccountDTO;
import com.bozduran.site.entities.Account;
import com.bozduran.site.repository.AccountCredentialsRepository;
import com.bozduran.site.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
@Primary
public class AccountServiceImpl implements AccountService{


    private final AccountRepository accountRepository;

    private final AccountCredentialsRepository accountCredentialsRepository;

    private Map<UUID, AccountDTO> accountDTOMap;

    public List<Account> getAllPersons() {
        return (List<Account>) accountRepository.findAll();
    }

    public void addPerson(Account account) {
        accountRepository.save(account);
        accountCredentialsRepository.save(account.getAccountCredentials());
    }

    public boolean doesEmailAlreadyUsed(String email){
        return accountRepository.existsAccountByEmail(email);
    }

    public Account getAccountByUserName(String userName){
        return accountRepository.getAccountByAccountCredentials_UserName(userName);
    }

    public Optional<AccountDTO> getAccountById(UUID id){
        return Optional.of(accountDTOMap.get(id));
    }

}