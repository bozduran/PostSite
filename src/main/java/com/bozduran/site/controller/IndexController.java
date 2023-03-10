package com.bozduran.site.controller;

import com.bozduran.site.entities.TextPost;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping(value = "/" )
    public String getIndex(){
        return "index";
    }

    @RequestMapping(value = "/home")
    public String getHome(Model model){
        TextPost textPost = new TextPost();
        model.addAttribute("textPost",textPost);
        return "home";
    }



}
