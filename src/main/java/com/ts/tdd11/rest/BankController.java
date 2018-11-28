package com.ts.tdd11.rest;

import com.ts.tdd11.exception.BankNotFoundException;
import com.ts.tdd11.model.Bank;
import com.ts.tdd11.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankController {

    @Autowired
    BankService service;

    @GetMapping("/banks/{id}")
    private Bank getBank(@PathVariable("id") Long id) throws BankNotFoundException {
        return service.getBankById(id).orElseThrow(BankNotFoundException::new);
    }
}
