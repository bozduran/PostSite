package com.bozduran.site.controller;

import com.bozduran.site.entities.AccountCredentials;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogIn {

    @GetMapping("/login")
    public String getLogIn(Model theModel){
        theModel.addAttribute("accountCredentials",
                new AccountCredentials());

        return "login";
    }

}
