package com.bozduran.site.controller;

import com.bozduran.site.domain.Account;
import com.bozduran.site.domain.AccountCredentials;
import com.bozduran.site.service.AccountService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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

    public void dataAddToAccount(){
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/MOCK_DATA_ACCPUNTS.csv"))) {
            String line;
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                System.out.println(values[0] +" "+
                        values[1]+" "+
                        values[2]+" "+
                        values[3]+" "+values[4]);
                accountService.addPerson(
                        new Account(values[2],values[0],values[1],
                                new AccountCredentials(values[4],values[3] ))
                );
                //records.add(Arrays.asList(values));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
