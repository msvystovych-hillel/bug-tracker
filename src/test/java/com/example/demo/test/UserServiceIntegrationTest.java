package com.example.demo.test;

import com.example.demo.abstractcrud.model.User;
import com.example.demo.abstractcrud.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//@TestExecutionListeners({
//        TransactionalTestExecutionListener.class,
//        DependencyInjectionTestExecutionListener.class,
//        DbUnitTestExecutionListener.class
//})
@Slf4j
public class UserServiceIntegrationTest extends AbstractIntegrationTest {

    @Autowired
    private UserService userService;

    @Test
    void testGetAllUsers() {
        Optional<Iterable<User>> all = userService.getAll();
        List<User> result = new ArrayList<>();
        all.get().forEach(result::add);
        log.info("SIZE: {}", result.size());
        Assertions.assertFalse(result.isEmpty());
    }
}