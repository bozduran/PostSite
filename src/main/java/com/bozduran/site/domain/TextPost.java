package com.bozduran.site.domain;

import jakarta.persistence.DiscriminatorValue;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Entity;
import lombok.ToString;

@Getter
@Setter
@Entity
@NoArgsConstructor
@ToString
@DiscriminatorValue("TextPost")
public class TextPost extends Post{

    private String postText;

    public TextPost(String postText){
        super();
        this.postText = postText;
    }


}
