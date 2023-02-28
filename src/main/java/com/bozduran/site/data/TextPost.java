package com.bozduran.site.data;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Entity;

@Getter
@Setter
@Entity
@NoArgsConstructor
@DiscriminatorValue("TextPost")
public class TextPost extends Post{

    private String postText;

    public TextPost(String postText){
        super();
        this.postText = postText;
    }


}
