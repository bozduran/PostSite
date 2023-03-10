package com.bozduran.site.entities;

import jakarta.persistence.DiscriminatorValue;
import lombok.*;

import jakarta.persistence.Entity;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@DiscriminatorValue("TextPost")
public class TextPost extends Post{

    private String postText;



}
