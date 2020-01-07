package com.demo.demoProject.services;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ContextConfiguration(classes = {HelloService.class})
@RunWith(SpringRunner.class)
class HelloServiceTests {
    @Autowired
    private HelloService service;

    @Test
    public void hello() {
        String hello = service.hello();
        assertThat(hello).isNotEmpty();
        assertThat(hello).contains("Hello World!!!");
    }


}
