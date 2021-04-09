package com.example.demo.aop;

import org.springframework.stereotype.Component;

@Component
public class SomeService {

    @LogExecutionTime
    public void serve() throws InterruptedException {
        Thread.sleep(2000);
    }
}
