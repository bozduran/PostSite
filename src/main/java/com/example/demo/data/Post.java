package com.example.demo.data;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "POST")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Post {

    @Id
    private String id;
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
