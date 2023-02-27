package com.example.demo.data;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;


import java.time.ZoneId;
import java.util.Date;

@Entity
@Table(name = "ACCOUNT_CREDENTIALS")
public class AccountCredentials {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "acc_cred_id")
    private Long id;
    private String userName;
    private String passwordHash;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="Europe/Athens")
    private Date dateOfPasswordChange;

    public AccountCredentials(String userName, String passwordHash) {
        this.userName = userName;
        this.passwordHash = passwordHash;
    }

    public AccountCredentials() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    @Override
    public String toString() {
        return "AccountCredentials{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                ", dateOfPasswordChange=" + dateOfPasswordChange +
                '}';
    }

    public Date getDateOfPasswordChange() {
        return dateOfPasswordChange;
    }

    public void setDateOfPasswordChange(Date dateOfPasswordChange) {
        this.dateOfPasswordChange = dateOfPasswordChange;
    }

}
