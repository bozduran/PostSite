package com.bozduran.site.repository;

import com.bozduran.site.domain.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface PostRepository extends CrudRepository<Post,Long> {


    Post getPostById(Long id);
}
