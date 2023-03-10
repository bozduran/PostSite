package com.bozduran.site.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * A DTO for the {@link com.bozduran.site.entities.AccountCredentials} entity
 */
@Data
@Builder
public class AccountCredentialsDTO implements Serializable {
    private final UUID id;
    private final String userName;
    @NotEmpty(message = "Must be at least 8 character long.")
    @Size(min = 8, message = "Must be at least 8 character long.")
    @Size(min = 8)
    private final String passwordHash;
    private final Date dateOfPasswordChange;
}