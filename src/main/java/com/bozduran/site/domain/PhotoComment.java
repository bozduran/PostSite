package com.bozduran.site.domain;

import jakarta.persistence.DiscriminatorValue;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Entity;

@Setter
@Getter
@NoArgsConstructor
@Entity
@DiscriminatorValue("PhotoPost")
public class PhotoComment extends Comment {
    public String photoCommentName;

    public PhotoComment(String photoCommentName){
        super();
        this.photoCommentName = photoCommentName;
    }
}
