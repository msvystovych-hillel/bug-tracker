package com.example.demo.conditions;

import com.example.demo.configuration.MySQLDatabaseTypeCondition;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Slf4j
@Conditional(MySQLDatabaseTypeCondition.class)
public class MySQLDatabaseTypeConditionExampleBean {
    @PostConstruct
    public void init() {
        log.info("----------MySQLDatabaseTypeConditionExampleBean created");
    }
}
