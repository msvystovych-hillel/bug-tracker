package com.example.demo.spring1;

import com.example.demo.repository.TestRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
@Slf4j
public class TestApplicationContext {
    @Autowired
    private ApplicationContext appContext;

    public void test() {
        TestRepository testRepository = appContext.getBean(TestRepository.class);
        Long count = testRepository.count();
        log.info("count {}", count);
        DataSource dataSource = appContext.getBean(DataSource.class);
    }
}
