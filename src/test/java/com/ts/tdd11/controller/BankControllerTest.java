package com.ts.tdd11.controller;

import com.ts.tdd11.model.Bank;
import com.ts.tdd11.service.BankService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class BankControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    BankService service;

    @Test
    public void getBankTest() throws Exception {
        // Arrange
        when(service.getBankById(1L)).thenReturn(new Bank(1L, "10x"));

        // Act
        mockMvc.perform(get("/banks/{id}","1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").value("1"))
                .andExpect(jsonPath("name").value("10x"));
    }
}
