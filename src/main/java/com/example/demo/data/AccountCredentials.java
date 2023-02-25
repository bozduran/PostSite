package com.example.demo.data;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;
@Entity
@Table(name = "ACCOUNT_CREDENTIALS")
public class AccountCredentials {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String userName;
    private String passwordHash;
    private LocalDateTime dateOfPasswordChange;
    private int accountId;

    public AccountCredentials(String userName, String passwordHash, int accountId) {
        this.userName = userName;
        this.passwordHash = passwordHash;
        this.dateOfPasswordChange = LocalDateTime.now();;
        this.accountId = accountId;
    }

    public AccountCredentials() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public LocalDateTime getDateOfPasswordChange() {
        return dateOfPasswordChange;
    }

    public void setDateOfPasswordChange(LocalDateTime dateOfPasswordChange) {
        this.dateOfPasswordChange = dateOfPasswordChange;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
}
