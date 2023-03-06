package com.bozduran.site.domain;

import com.bozduran.site.validation.UniqueEmail;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.*;

@Entity
@Component
@Getter
@Setter
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accountId;
    @Email(message="Not an email.")
    @Column(unique=true)
    private String email;
    @NotEmpty(message="Firstname is required")
    @Size(min = 1)
    private String firstName;
    @NotEmpty(message="Lastname is required")
    @Size(min=1)
    private String lastName;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="Europe/Athens")
    private Date dateOfCreation;
    @OneToOne(cascade = {CascadeType.ALL})
    private AccountCredentials accountCredentials;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "account",cascade = CascadeType.ALL)
    private Set<Post> posts = new HashSet<>();

    public Account(String email, String firstName, String lastName,
                   AccountCredentials accountCredentials) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountCredentials = accountCredentials;
    }

    public void addPostToAccount(Post post){
        posts.add(post);
    }
}
