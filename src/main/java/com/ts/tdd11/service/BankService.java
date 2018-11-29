package com.ts.tdd11.service;

import com.ts.tdd11.model.Bank;
import com.ts.tdd11.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BankService {

    @Autowired
    BankRepository  repository;

    public BankService(BankRepository repository) {
        this.repository = repository;
    }

    @Cacheable("bankCache")
    public Optional<Bank> getBankById(Long id) {
        return repository.findById(id);
    }
}
