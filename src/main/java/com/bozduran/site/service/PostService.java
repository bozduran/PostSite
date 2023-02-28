package com.bozduran.site.service;

import com.bozduran.site.data.Post;
import com.bozduran.site.repository.PostRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    private PostRepository postRepository;

    public void addPost(Post thePost){
        postRepository.save(thePost);
    }

}
