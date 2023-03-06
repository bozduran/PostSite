package com.bozduran.site.domain;

import jakarta.persistence.DiscriminatorValue;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@Entity
@DiscriminatorValue("PhotoPost")
public class PhotoPost extends Post{

    private String photoFileName;

    public PhotoPost(String photoFileName){
        super();
        this.photoFileName = photoFileName;
    }




}
