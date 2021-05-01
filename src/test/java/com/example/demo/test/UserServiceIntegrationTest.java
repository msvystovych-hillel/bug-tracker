package com.example.demo.test;

import com.example.demo.abstractcrud.model.User;
import com.example.demo.abstractcrud.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@ContextConfiguration(initializers = {UserServiceIntegrationTest.Initializer.class})
@Slf4j
class UserServiceIntegrationTest {

    @Autowired
    private UserService userService;



    static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
            TestPropertyValues.of(
                    "spring.datasource.url=" + "jdbc:mysql://localhost:3306/testDB?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true",
                    "spring.datasource.username=" + "root",
                    "spring.datasource.password=" + "my-secret-pw"
            ).applyTo(configurableApplicationContext.getEnvironment());
        }
    }


    @Test
    void testGetAllUsers() {
        Optional<Iterable<User>> all = userService.getAll();
        List<User> result = new ArrayList<>();
        all.get().forEach(result::add);
        Assertions.assertFalse(result.isEmpty());

    }

}