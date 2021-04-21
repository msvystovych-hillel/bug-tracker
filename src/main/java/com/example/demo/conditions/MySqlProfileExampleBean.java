package com.example.demo.conditions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Slf4j
@Profile("localMySqlProfile")
public class MySqlProfileExampleBean {
    @PostConstruct
    public void init() {
        log.info("----------MySqlProfileExampleBean created");
    }
}
