package com.demo.demoProject.controllers;

import com.demo.demoProject.AOP.Logger.Print;
import com.demo.demoProject.entity.Account;
import com.demo.demoProject.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/account")
public class AccountController {
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @Print
    @GetMapping(value = "/")
    public List<Account> getAll() {
        return accountService.getAll();
    }

    @Print
    @GetMapping(value = "/findById")
    public Account findById(@RequestParam Long id) {
        return accountService.findById(id);
    }

    @Print
    @GetMapping("/findByEmail")
    public Account findByEmail(@RequestParam String email) {
        return accountService.findByEmail(email);
    }
}
