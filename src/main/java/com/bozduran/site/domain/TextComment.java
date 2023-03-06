package com.bozduran.site.domain;

import jakarta.persistence.DiscriminatorValue;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Entity;

@Setter
@Getter
@Entity
@NoArgsConstructor
@DiscriminatorValue("TextComment")
public class TextComment extends Comment {

    public String text;

    public TextComment(String text){
        super();
        this.text = text;
    }


}
