package com.bozduran.site.data;

import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Entity
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "textPost")
public class TextPost extends Post{

    private String postText;

    public TextPost(String postText){
        super();
        this.postText = postText;
    }


}
