package com.ts.tdd11.repository;

import com.ts.tdd11.model.Bank;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends CrudRepository<Bank,Long>{



}
