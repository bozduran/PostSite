package com.bozduran.site.model;

import com.bozduran.site.entities.Account;
import com.bozduran.site.entities.Comment;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

/**
 * A DTO for the {@link com.bozduran.site.entities.Post} entity
 */
@Data
@Builder
public class PostDTO implements Serializable {
    private final UUID id;
    private final Date dateOfCreation;
    private final int upVote;
    private final int downVotes;
    private final Account account;
    private final Set<Comment> comments;
}