package com.bozduran.site.data;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "COMMENTS")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="comment_type",
        discriminatorType = DiscriminatorType.STRING)
public abstract class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date dateOfCreation;

    private Long userId;
    public Comment(Long userId){
        this.userId = userId;
        this.dateOfCreation = new Date();
    }
}
