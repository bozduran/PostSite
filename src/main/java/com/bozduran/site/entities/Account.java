package com.bozduran.site.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(length = 36, columnDefinition = "varchar", updatable = false, nullable = false)
    private UUID id;
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

    public void addPostToAccount(Post post){
        posts.add(post);
    }
}
