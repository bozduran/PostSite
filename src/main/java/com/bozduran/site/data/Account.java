package com.bozduran.site.data;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Component
@Getter
@Setter
@NoArgsConstructor
@Table(name = "ACCOUNTS")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accountId;
    @Email(message="Not an email.")
    @Column(unique=true)
    private String email;
    @NotEmpty(message="Firstname is required")
    private String firstName;
    @NotEmpty(message="Lastname is required")
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
