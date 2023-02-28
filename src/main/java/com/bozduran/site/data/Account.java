package com.bozduran.site.data;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.UniqueElements;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "ACCOUNTS")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accountId;
    @NotNull(message = "Email must be put on")
    @UniqueElements
    private String email;
    private String firstName;
    private String lastName;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="Europe/Athens")
    private Date dateOfCreation;
    @OneToOne(cascade = {CascadeType.ALL})
    private AccountCredentials accountCredentials;

    @OneToMany()
    private List<Post> posts;

    public Account(String email, String firstName, String lastName,
                   AccountCredentials accountCredentials) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountCredentials = accountCredentials;
        this.posts = new ArrayList<>();
    }

    public void addPostToAccount(Post post){
        posts.add(post);
    }
}
