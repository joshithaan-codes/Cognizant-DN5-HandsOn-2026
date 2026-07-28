package com.cognizant.loanservice.controller;

import com.cognizant.loanservice.model.Loan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {

    @GetMapping("/loans")
    public Loan getLoan() {

        return new Loan(
                "LN1001",
                "Home Loan",
                2500000
        );
    }
}