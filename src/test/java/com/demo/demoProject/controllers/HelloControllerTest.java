package com.demo.demoProject.controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = HelloController.class)
public class HelloControllerTest {
    @MockBean
    private HelloController helloController;
    @Autowired
    private MockMvc mockMvc;

    @Before
    public void init() {
        when(helloController.index())
                .thenReturn("Hello world!!!");
    }

    @Test
    public void index() throws Exception {
        String expected = "Hello world!!!";
        mockMvc
                .perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string(expected))
                .andDo(print());
    }
}