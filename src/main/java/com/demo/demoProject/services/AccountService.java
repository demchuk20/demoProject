package com.demo.demoProject.services;

import com.demo.demoProject.AOP.Logger.Print;
import com.demo.demoProject.entity.Account;
import com.demo.demoProject.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AccountService {
    final private AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Print
    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    @Print
    public Account findById(Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() ->
                        new NoSuchElementException("Account with id = " + id + " not exist"));
    }

    @Print
    public Account findByEmail(String email) {
        return accountRepository.findAccountByEmail(email)
                .orElseThrow(() ->
                        new NoSuchElementException("Account with email " + email + " not exist"));
    }
}
