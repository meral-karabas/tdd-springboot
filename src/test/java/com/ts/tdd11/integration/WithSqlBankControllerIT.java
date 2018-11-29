package com.ts.tdd11.integration;

import com.ts.tdd11.model.Bank;
import com.ts.tdd11.repository.BankRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
@SqlGroup({
        @Sql(executionPhase = BEFORE_TEST_METHOD, statements = "INSERT INTO BANK values (1,'10x')"),
        @Sql(executionPhase = AFTER_TEST_METHOD, statements = "DELETE from BANK")
})
public class WithSqlBankControllerIT {

    @Autowired
    TestRestTemplate    template;

    @Autowired
    BankRepository repository;

    @Test
    public  void getBanksTest(){
        repository.findAll().forEach(System.out::println);
        // Act
        ResponseEntity<Bank> response = template.getForEntity("/banks/{id}", Bank.class, "1");

        // Assert
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().getId()).isEqualTo(1L);
        assertThat(response.getBody().getName()).isEqualTo("10x");
    }


}
