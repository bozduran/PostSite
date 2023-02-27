package com.example.demo.controller;

import com.example.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.data.Account;

import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {


    @Autowired
    AccountService accountService;
    @GetMapping(value = "/create-account")
    public String getCreateAccount(Model theModel){
        // create a student object
        Account theAcount = new Account();

        // add student object to the model
        theModel.addAttribute("account", theAcount);
        return "create-account";
    }

    @RequestMapping("/create-account/confirmation")
    public String processForm(@ModelAttribute("account") Account theAccount) {
        accountService.addPerson(theAccount);
        accountService.getAllPersons();
        System.out.println(theAccount.toString() );
        return "account-confirmation";
    }

    @RequestMapping(value ="/all")
    public String getAllAccount(Model model){
        model.addAttribute("accounts" ,accountService.getAllPersons());
        return "all-accountsDenug";
    }

}
