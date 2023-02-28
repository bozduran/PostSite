package com.bozduran.site.repository;

import com.bozduran.site.data.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post,Long> {
}
