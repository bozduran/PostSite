package com.bozduran.site.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

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
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(length = 36, columnDefinition = "varchar", updatable = false, nullable = false)
    private UUID id;
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

