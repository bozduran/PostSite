package com.bozduran.site.repository;

import com.bozduran.site.domain.AccountCredentials;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountCredentialsRepository extends CrudRepository<AccountCredentials, Long> {
}