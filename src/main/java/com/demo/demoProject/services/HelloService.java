package com.demo.demoProject.services;

import com.demo.demoProject.AOP.Logger.Print;
import org.springframework.stereotype.Service;

@Service
public class HelloService {
    @Print
    public String hello() {
        return "Hello World!!!";
    }
}
