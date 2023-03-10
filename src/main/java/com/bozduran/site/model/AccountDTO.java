package com.bozduran.site.model;

import com.bozduran.site.entities.AccountCredentials;
import com.bozduran.site.entities.Post;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

/**
 * A DTO for the {@link com.bozduran.site.entities.Account} entity
 */
@Data
@Builder
public class AccountDTO implements Serializable {
    private final UUID id;
    @Email(message = "Not an email.")
    private final String email;
    @NotEmpty(message = "Firstname is required")
    @Size(min = 1)
    private final String firstName;
    @NotEmpty(message = "Lastname is required")
    @Size(min = 1)
    private final String lastName;
    private final Date dateOfCreation;
    private final AccountCredentials accountCredentials;
    private final Set<Post> posts;
}