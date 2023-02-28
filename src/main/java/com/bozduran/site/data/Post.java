package com.bozduran.site.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "POST")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="post_type",
        discriminatorType = DiscriminatorType.STRING)
public abstract class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

