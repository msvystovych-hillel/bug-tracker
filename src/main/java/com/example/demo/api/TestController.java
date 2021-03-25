package com.example.demo.api;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.repository.TestJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private TestJpaRepository testJpaRepository;


    @GetMapping("/test")
    public List<User> test() {
        return testJpaRepository.getAllUsers();
    }

    @GetMapping("/roles")
    public List<Role> getAllRoles() {
//        testRepository.testInsert();
//        return testRepository.count();
        return testJpaRepository.getAllRoles();
    }

    @GetMapping("/save-user")
    public void saveUser() {
        testJpaRepository.saveUser();
    }
}
