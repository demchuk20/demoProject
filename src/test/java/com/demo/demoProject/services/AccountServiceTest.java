package com.demo.demoProject.services;

import com.demo.demoProject.entity.Account;
import com.demo.demoProject.entity.RoleType;
import com.demo.demoProject.repository.AccountRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AccountService.class)
public class AccountServiceTest {
    @MockBean
    private AccountRepository accountRepository;

    @Autowired
    private AccountService accountService;

    private Account getFakeAccount() {
        return Account.builder()
                .id(1L)
                .name("Name")
                .surname("Surname")
                .email("test@mail")
                .registryTime(Date.valueOf(LocalDate.now()))
                .password("1234")
                .role(RoleType.USER)
                .build();
    }

    @Before
    public void init() {
        when(accountRepository.findAll())
                .thenReturn(Collections.singletonList(getFakeAccount()));
        when(accountRepository.findAccountByEmail("test@mail"))
                .thenReturn(Optional.of(getFakeAccount()));
        when(accountRepository.findById(1L))
                .thenReturn(Optional.of(getFakeAccount()));

    }

    @Test
    public void getAll() {
        List<Account> actual = accountService.getAll();
        List<Account> expected = Collections.singletonList(getFakeAccount());
        assertThat(actual).hasSameSizeAs(expected);
        assertEquals(actual, expected);
    }

    @Test
    public void findById() {
        Account actual = accountService.findById(1L);
        assertEquals(actual, getFakeAccount());
    }

    @Test
    public void findByEmail() {
        Account actual = accountService.findByEmail("test@mail");
        assertEquals(actual, getFakeAccount());
    }
}