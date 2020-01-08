package com.demo.demoProject.controllers;

import com.demo.demoProject.AOP.Logger.Print;
import com.demo.demoProject.services.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/")
public class HelloController {
    private final HelloService helloService;

    @Autowired
    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @Print
    @GetMapping(value = "/")
    public List<String> index() {
        return Collections.singletonList(helloService.hello());
    }
}
