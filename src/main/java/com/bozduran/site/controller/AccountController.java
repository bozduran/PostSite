package com.bozduran.site.controller;

import com.bozduran.site.entities.Account;
import com.bozduran.site.entities.AccountCredentials;
import com.bozduran.site.exceptions.NotFoundException;
import com.bozduran.site.service.AccountService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

@Controller
@RequestMapping("/account")
@AllArgsConstructor
public class AccountController {

    private AccountService accountService;

    @GetMapping(value = "/create-account")
    public String getCreateAccount(Model theModel){

        Account theAccount = new Account();

        theModel.addAttribute("account", theAccount);

        return "create-account";
    }

    @RequestMapping("/create-account/confirmation")
    public String processForm(@Valid Account theAccount ,
                              BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "create-account";
        }
        theAccount.setDateOfCreation(new Date());
        accountService.addPerson(theAccount);
        accountService.getAllPersons();
        System.out.println(theAccount.toString() );
        return "account-confirmation";
    }

    @RequestMapping(value ="/all")
    public String getAllAccount(Model model){
        model.addAttribute("accounts" ,accountService.getAllPersons());
        return "all-accountsDenug".describeConstable().orElseThrow(NotFoundException::new);
    }


}
