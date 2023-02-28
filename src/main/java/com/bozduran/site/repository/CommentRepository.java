package com.bozduran.site.repository;

import com.bozduran.site.data.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Long> {
}