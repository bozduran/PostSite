package com.bozduran.site.service;

import com.bozduran.site.domain.Account;

public interface AccountService {
    void addPerson(Account account);

    boolean doesEmailAlreadyUsed(String email);

    Object getAllPersons();
}
