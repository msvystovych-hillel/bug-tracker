package com.example.demo.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
class ValidateRequestBodyController {

    @PostMapping("/validateBody")
    public ResponseEntity<String> validateBody(@Valid @RequestBody UserDto input) {
        return ResponseEntity.ok("valid");
    }

}