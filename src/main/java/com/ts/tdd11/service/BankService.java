package com.ts.tdd11.service;

import com.ts.tdd11.model.Bank;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BankService {
    public Optional<Bank> getBankById(Long id) {
        return Optional.of(new Bank(id,"10x"));
    }
}
