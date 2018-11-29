package com.ts.tdd11.service;


import com.ts.tdd11.exception.BankNotFoundException;
import com.ts.tdd11.model.Bank;
import com.ts.tdd11.repository.BankRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static java.util.Optional.empty;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BankServiceTest {

    BankService service;

    @Mock
    BankRepository repository;

    @Before
    public void setup(){
        service = new BankService(repository);
    }

    @Test
    public void  getBankTest(){

        // Arrange
        when(repository.findById(anyLong())).thenReturn(Optional.of(new Bank(1L,"10x")));


        // Act
        Bank bank = service.getBankById(1L);

        // Assert
        assertThat(bank).isNotNull();
        assertThat(bank.getId()).isEqualTo(1L);
        assertThat(bank.getName()).isEqualTo("10x");
    }


    @Test(expected= BankNotFoundException.class)
    public void  whenBankNotFound_thenThrowError(){
        // Arrange
        when(repository.findById(2L)).thenReturn(empty());

        // Act
        Bank bank = service.getBankById(2L);
    }



}
