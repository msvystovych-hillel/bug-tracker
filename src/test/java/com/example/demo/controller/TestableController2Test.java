package com.example.demo.controller;

import com.example.demo.abstractcrud.repository.UserRepository;
import com.example.demo.abstractcrud.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@RunWith(SpringRunner.class)
@WebMvcTest(value = TestableController.class)
@Slf4j
public class TestableController2Test {

    @Autowired
    private MockMvc mvc;

    @SpyBean
    private UserService userService;

    @MockBean
    private UserRepository userRepository;


    @Test
    public void test5() throws Exception {
        mvc.perform(MockMvcRequestBuilders
                .get("/test5")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(userRepository).findAll();
    }

}