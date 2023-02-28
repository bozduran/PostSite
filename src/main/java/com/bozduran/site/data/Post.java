package com.bozduran.site.data;

import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "POST")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Post {

    @Id
    private Long id;
    private Date dateOfCreation;
    private int upVote;
    private int downVotes;
    @OneToMany()
    private List<Post> comments;

    public Post(){
        this.dateOfCreation = new Date();
    }

    public void addCommentToPost(Post comment){
        comments.add(comment);
    }

}

