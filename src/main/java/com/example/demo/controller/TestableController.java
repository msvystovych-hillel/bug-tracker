package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestableController {

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

}
