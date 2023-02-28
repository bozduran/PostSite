package com.bozduran.site.service;

import com.bozduran.site.repository.PostRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;


@Service
public class CommentService {

    private PostRepository postRepository;

}
