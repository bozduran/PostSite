package com.example.demo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping(value = {"/" ,"/home"})
    public String getIndex(){
        return "index";
    }

    @RequestMapping(value = "/create")
    public String getCreate(){
        return "create";
    }
}
