package com.example.demo.conditions;

import com.example.demo.configuration.DatabaseType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Slf4j
@DatabaseType("MYSQL-LOCAL")
public class DatabaseTypeAnnotationExampleBean {
    @PostConstruct
    public void init() {
        log.info("----------DatabaseTypeAnnotationExampleBean created");
    }
}
