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
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Comment {
    @Id
    private Long id;
    private Date dateOfCreation;

    private Long userId;
    public Comment(Long userId){
        this.userId = userId;
        this.dateOfCreation = new Date();
    }
}
