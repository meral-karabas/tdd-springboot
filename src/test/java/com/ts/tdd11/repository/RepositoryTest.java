package com.ts.tdd11.repository;

import com.ts.tdd11.model.Bank;
import com.ts.tdd11.repository.BankRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RepositoryTest {

    @Autowired
    TestEntityManager   entityManager;

    @Autowired
    BankRepository  repository;

    @Test
    public void getRepository(){
        // Arrange
        Bank bankExpected = entityManager.persist(new Bank( "10x"));

        // Act
        Optional<Bank> bankActual = repository.findById(1L);

        // Assert
        assertThat(bankActual.get().getName()).isEqualTo(bankExpected.getName());
        assertThat(bankActual.get().getId()).isEqualTo(bankExpected.getId());



    }

}
