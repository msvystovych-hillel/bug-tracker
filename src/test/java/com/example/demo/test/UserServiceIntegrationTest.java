package com.example.demo.test;

import com.example.demo.abstractcrud.model.User;
import com.example.demo.abstractcrud.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@Slf4j
@ContextConfiguration(initializers = {AbstractIntegrationTest.Initializer.class})
class UserServiceIntegrationTest extends AbstractIntegrationTest {

    @Autowired
    private UserService userService;


    @Test
    void testGetAllUsers() {
        Optional<Iterable<User>> all = userService.getAll();
        List<User> result = new ArrayList<>();
        all.get().forEach(result::add);
        Assertions.assertFalse(result.isEmpty());
    }
}