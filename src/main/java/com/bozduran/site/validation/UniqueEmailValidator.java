package com.bozduran.site.validation;

import com.bozduran.site.service.AccountService;
import com.bozduran.site.service.AccountServiceImpl;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
public class UniqueEmailValidator
        implements ConstraintValidator<UniqueEmail,String> {

    @Autowired
    private final AccountService accountService;


    @Override
    public void initialize(UniqueEmail constraintAnnotation) {
        System.out.println("init");
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {

       return accountService.doesEmailAlreadyUsed(email);

    }
}
