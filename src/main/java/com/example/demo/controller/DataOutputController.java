package com.example.demo.controller;

import com.example.demo.data.User;
import com.example.demo.repository.JdbcRepositoryImpl;
import org.springframework.stereotype.Controller;

import java.util.List;

//Controller - control the flow of app execution. Returning response. Coordinator between View - Model.
// receives input (from V.) -> processes data (M.) -> returns data (to V)
@Controller
public class DataOutputController {

    JdbcRepositoryImpl jdbcRepository = new JdbcRepositoryImpl();

    public void outputData(){
        List<User> users = jdbcRepository.getAll();

        for (User user : users) {
            System.out.println(user);
        }

    }

}
