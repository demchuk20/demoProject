package com.demo.demoProject.controllers;

import com.demo.demoProject.AOP.Logger.Print;
import com.demo.demoProject.services.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloController {
    private final HelloService helloService;

    @Autowired
    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @Print
    @GetMapping("/")
    public String index(){
        return helloService.hello();
    }
}
