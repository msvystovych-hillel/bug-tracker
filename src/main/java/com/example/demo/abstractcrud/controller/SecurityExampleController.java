package com.example.demo.abstractcrud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityExampleController {

    @GetMapping("/user/get")
    public String getUser() {
        return "USER ENTITY";
    }
}
