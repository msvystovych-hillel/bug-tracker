package com.example.demo.controller;

import com.example.demo.abstractcrud.model.User;
import com.example.demo.abstractcrud.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
public class TestableController {

    @Autowired
    public UserService userService;

    @GetMapping("/test1")
    public String test1() {
        return "OK";
    }

    @GetMapping("/test2")
    public IdNamePair test2() {
        return new IdNamePair("1", "John");
    }

    @GetMapping("/test3")
    public List<IdNamePair> test3() {
        return List.of(new IdNamePair("1", "John"), new IdNamePair("2", "Bob"));
    }

    @GetMapping("/test4")
    public List<IdNamePair> test4() {
        return userService.getAllStubData();
    }

    @GetMapping("/test5")
    public List<User> test5() {
        Optional<Iterable<User>> all = userService.getAll();
        List<User> result = new ArrayList<>();
        all.get().forEach(result::add);
        log.info("SIZE: {}", result.size());
        return result;
    }
}
