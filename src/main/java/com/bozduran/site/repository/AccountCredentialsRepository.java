package com.bozduran.site.repository;

import com.bozduran.site.entities.AccountCredentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AccountCredentialsRepository extends JpaRepository<AccountCredentials, UUID> {
}