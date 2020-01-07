package com.demo.demoProject.controllers;

import com.demo.demoProject.entity.Account;
import com.demo.demoProject.entity.RoleType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Collections;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = AccountController.class)
public class AccountControllerTest {
    @MockBean
    private AccountController accountController;
    @Autowired
    private MockMvc mockMvc;

    @Before
    public void init() {
        when(accountController.getAll())
                .thenReturn(Collections.singletonList(getFakeAccount()));
        when(accountController.findByEmail("test@mail"))
                .thenReturn(getFakeAccount());
        when(accountController.findById(1L))
                .thenReturn(getFakeAccount());

    }

    private Account getFakeAccount() {
        return Account.builder()
                .id(1L)
                .name("Name")
                .surname("Surname")
                .email("test@mail")
                .password("1234")
                .role(RoleType.USER)
                .build();
    }

    private String asJsonString(final Object object) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(object);
    }

    @Test
    public void getAll() throws Exception {
        String expected = asJsonString(Collections.singletonList(getFakeAccount()));
        mockMvc
                .perform(get("/account/"))
                .andExpect(status().isOk())
                .andExpect(content().string(expected))
                .andDo(print());
    }

    @Test
    public void findById() throws Exception {
        String expected = asJsonString(getFakeAccount());
        mockMvc
                .perform(get("/account/findById?id=1"))
                .andExpect(status().isOk())
                .andExpect(content().string(expected))
                .andDo(print());
    }

    @Test
    public void findByEmail() throws Exception {
        String expected = asJsonString(getFakeAccount());
        mockMvc
                .perform(get("/account/findByEmail?email=test@mail"))
                .andExpect(status().isOk())
                .andExpect(content().string(expected))
                .andDo(print());
    }
}