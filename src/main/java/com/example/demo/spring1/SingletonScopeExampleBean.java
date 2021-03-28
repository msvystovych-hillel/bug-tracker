package com.example.demo.spring1;

import lombok.Data;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Data
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
@Component
public class SingletonScopeExampleBean {
    private String value;
}
