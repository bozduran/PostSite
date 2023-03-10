package com.bozduran.site.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import java.util.UUID;

@Entity
@Setter
@Getter
//@Table(name = "COMMENTS")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="comment_type",
        discriminatorType = DiscriminatorType.STRING)
public abstract class Comment {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(length = 36, columnDefinition = "varchar", updatable = false, nullable = false)
    private UUID id;
    private Date dateOfCreation;


    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private Post post;
    public Comment(){
        this.dateOfCreation = new Date();
    }
}
