package com.bozduran.site.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Setter
@Getter
//@Table(name = "COMMENTS")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="comment_type",
        discriminatorType = DiscriminatorType.STRING)
public abstract class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date dateOfCreation;


    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Post post;
    public Comment(){
        this.dateOfCreation = new Date();
    }
}
