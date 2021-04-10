package com.example.demo.aop;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SomeService {

    @LogExecutionTime
    public void serve() throws InterruptedException {
        Thread.sleep(2000);
    }

    public void methodForLogging(List<String> list) {
        int size = list.size();
    }
}
