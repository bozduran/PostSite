package com.bozduran.site.model;

import com.bozduran.site.entities.Post;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * A DTO for the {@link com.bozduran.site.entities.PhotoComment} entity
 */
@Data
@Builder
public class PhotoCommentDTO implements Serializable {
    private final UUID id;
    private final Date dateOfCreation;
    private final Post post;
    private final String photoCommentName;
}