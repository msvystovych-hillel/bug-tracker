package com.example.demo.conditions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
    @ConditionalOnProperty(
            name = "usemysql",
            havingValue = "local")
@Slf4j
public class ConditionalOnPropertyExampleBean {

    @PostConstruct
    public void init() {
        log.info("----------ConditionalOnPropertyExampleBean created");
    }
}
