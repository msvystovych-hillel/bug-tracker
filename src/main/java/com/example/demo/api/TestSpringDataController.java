package com.example.demo.api;

import com.example.demo.model.OldUser;
import com.example.demo.repository.UserDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestSpringDataController {
    @Autowired
    private UserDataJpaRepository userDataJpaRepository;



    @GetMapping("/old-user")
    public OldUser testGetUser() {
        return userDataJpaRepository.findByName("Bob");
    }

    @GetMapping("/old-user-native")
    public OldUser testGetUserUsingNativeQuery() {
        return userDataJpaRepository.getByNameUsingNativeQuery("Bob");
    }

    @GetMapping("/old-users")
    public List<OldUser> testAllUsers() {
        return userDataJpaRepository.findAllByOrderByIdDesc();
    }
}
