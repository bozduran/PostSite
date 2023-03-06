package com.bozduran.site.controller;

import com.bozduran.site.domain.TextPost;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/post")
public class PostController {

    @RequestMapping("/create-new-post")
    public String createNewPost(@ModelAttribute("textPost") TextPost thePost){
        System.out.println(thePost.getPostText());
        return "redirect:/";
    }
}
