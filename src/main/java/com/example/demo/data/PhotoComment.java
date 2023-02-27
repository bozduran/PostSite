package com.example.demo.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Setter
@Getter
@NoArgsConstructor
@Entity
@PrimaryKeyJoinColumn(name = "photoComment")
public class PhotoComment extends Comment {
    public String photoCommentName;

    public PhotoComment(String photoCommentName){
        super();
        this.photoCommentName = photoCommentName;
    }
}
