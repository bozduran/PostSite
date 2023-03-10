package com.bozduran.site.model;

import com.bozduran.site.entities.Comment;
import com.bozduran.site.entities.Post;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * A DTO for the {@link Comment} entity
 */
@Data
@Builder
public class CommentDTO implements Serializable {
    private final UUID id;
    private final Date dateOfCreation;
    private final Post post;
}