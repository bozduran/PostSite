package com.bozduran.site.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Setter
@Getter
@ToString
//@Table(name = "POST")
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

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Account account;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "post",cascade = CascadeType.ALL)
    private Set<Comment> comments;
    public Post(){
        this.dateOfCreation = new Date();
    }


}

