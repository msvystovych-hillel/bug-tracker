package com.example.demo.controller;

import com.example.demo.data.User;
import com.example.demo.repository.AbstractRepository;
import com.example.demo.repository.JdbcRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

//Controller - control the flow of app execution. Returning response. Coordinator between View - Model.
// receives input (from V.) -> processes data (M.) -> returns data (to V)
@Controller
public class DataOutputController {

    @Autowired
    AbstractRepository jdbcRepository;

    @GetMapping("/test")
    public void outputData(){
        List<User> users = jdbcRepository.getAll();

        for (User user : users) {
            System.out.println(user);
        }

    }

}
