package com.bozduran.site.data;

import jakarta.persistence.DiscriminatorValue;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

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
