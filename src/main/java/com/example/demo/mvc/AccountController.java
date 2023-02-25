package com.example.demo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.data.Account;
@Controller
@RequestMapping("/account")
public class AccountController {
    @GetMapping(value = "/create-account")
    public String getCreateAccount(Model theModel){
        // create a student object
        Account theAcount = new Account();

        // add student object to the model
        theModel.addAttribute("account", theAcount);
        return "create-account";
    }

    @RequestMapping("/create-account/confrimation")
    public String processForm(@ModelAttribute("account") Account theStudent) {

        // log the input data
        System.out.println("theAccount: " + theStudent.getFirstName()
                + " " + theStudent.getLastName());

        return "account-confirmation";
    }

}
