package com.example.demo.api;

import com.example.demo.repository.TestConnectionPoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

//    @Autowired
//    private TestRepository testRepository;

    @Autowired
    private TestConnectionPoolRepository testConnectionPoolRepository;



    @GetMapping("/test")
    public long test() {
//        testRepository.testInsert();
//        return testRepository.count();
        return testConnectionPoolRepository.count();
    }
}
