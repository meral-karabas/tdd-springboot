package com.ts.tdd11.integration;

import com.ts.tdd11.model.Bank;
import com.ts.tdd11.repository.BankRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class BankControllerIT {
    @Autowired
    private TestRestTemplate    template;

    @Autowired
    private BankRepository repository;

    private Bank bank;

    @Before
    public void setup(){
        bank = new Bank("10x");
        repository.save(bank);
    }
    @After
    public void delete(){
        repository.delete(bank);
    }

    @Test
    public  void getBanksTest(){
        // Act
        ResponseEntity<Bank> response = template.getForEntity("/banks/{id}", Bank.class, "1");

        // Assert
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().getId()).isEqualTo(1L);
        assertThat(response.getBody().getName()).isEqualTo("10x");
    }


}
