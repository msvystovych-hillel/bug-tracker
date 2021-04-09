package com.example.demo.api;

import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

//    {
//        "email":"string@mail.com",
//            "id":null,
//            "login":"string",
//            "name":"string",
//            "password":"string",
//            "ip" :"192.168.1.1"
//    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces =
            MediaType.APPLICATION_JSON_VALUE)
    public String create(@Validated(UserDto.New.class) @RequestBody UserDto dto) {
        return "service.save(dto)";
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces =
            MediaType.APPLICATION_JSON_VALUE)
    public String updateName(@Validated(UserDto.UpdateName.class) @RequestBody UserDto dto) {
        return "service.update(dto)";
    }
}
