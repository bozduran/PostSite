package com.example.demo.data;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Setter
@Getter
@Entity
@PrimaryKeyJoinColumn(name = "textComment")
public class TextComment extends Comment {

    public String text;

    public TextComment(String text){
        super();
        this.text = text;
    }


}
