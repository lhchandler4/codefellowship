package com.huelismyfuellukehaha.ardvark.codefellowship;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc


public class AppUserControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testLogin() throws Exception {
        mockMvc.perform(get("/login")).andExpect(content().string(containsString("Welcome to the Codefellowship!")));
    }

    @Test
    public void testMyProfile() throws Exception {
        mockMvc.perform(get("/myprofile")).andExpect(content().string(containsString("")));
    }

}