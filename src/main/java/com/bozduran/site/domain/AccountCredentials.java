package com.bozduran.site.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
//@Table(name = "ACCOUNT_CREDENTIALS")
public class AccountCredentials {


    /*
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "acc_cred_id")
    private Long id;*/
    @Id
    @Column(unique = true)
    private String userName;
    @NotEmpty(message = "Must be at least 8 character long.")
    @Size(min = 8 ,message = "Must be at least 8 character long.")
    @Size(min = 8)
    private String passwordHash;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="Europe/Athens")
    private Date dateOfPasswordChange;

    public AccountCredentials(String userName, String passwordHash) {
        this.userName = userName;
        this.passwordHash = passwordHash;
    }


}