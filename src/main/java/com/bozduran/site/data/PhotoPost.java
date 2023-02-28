package com.bozduran.site.data;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.PrimaryKeyJoinColumn;
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
