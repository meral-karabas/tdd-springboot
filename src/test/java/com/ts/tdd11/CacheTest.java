package com.ts.tdd11;

import com.ts.tdd11.model.Bank;
import com.ts.tdd11.repository.BankRepository;
import com.ts.tdd11.service.BankService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CacheTest {

    @MockBean
    BankRepository repository;

    @Autowired
    BankService service;

    @Test
    public void  getBankCacheTest(){
        // Arrange
        when(repository.findById(anyLong())).thenReturn(Optional.of(new Bank(1L,"10x")));

        // Act
        Bank bank = service.getBankById(1L);
        Bank bank2 = service.getBankById(1L);

        // Assert
        verify(repository, times(1)).findById(any());
    }
}
