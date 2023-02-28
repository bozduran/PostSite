package com.bozduran.site.data;

import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@Entity
@PrimaryKeyJoinColumn(name = "photoPost")
public class PhotoPost extends Post{

    private String photoFileName;

    public PhotoPost(String photoFileName){
        super();
        this.photoFileName = photoFileName;
    }




}
