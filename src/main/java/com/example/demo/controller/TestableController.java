package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestableController {

    @GetMapping("/test1")
    public String test1() {
        return "OK";
    }
}
