package com.example.demo.spring1;

import com.example.demo.repository.TestRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
@Slf4j
public class TestApplicationContext {

    @Autowired
    private ApplicationContext appContext;


    public void testExistingAppContext() {
        TestRepository testRepository = appContext.getBean(TestRepository.class);
        Long count = testRepository.count();
        log.info("count {}", count);
        DataSource dataSource = appContext.getBean(DataSource.class);
    }

    public void testNewAppContext() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SomeConfig.class);
        for (String s : context.getBeanDefinitionNames()) {
            log.info("Bean definition is {}", s);
        }

        DataSource dataSourceFromSomeConfig = context.getBean(DataSource.class);
    }

    public void testBeanScopePrototype() {
        PrototypeScopeExampleBean beanOne = (PrototypeScopeExampleBean) appContext.getBean("prototypeScopeExampleBean");
        PrototypeScopeExampleBean beanTwo = (PrototypeScopeExampleBean) appContext.getBean("prototypeScopeExampleBean");
        beanOne.setValue("VALUE ONE");
        beanTwo.setValue("VALUE TWO");

        log.info(beanOne.getValue());
        log.info(beanTwo.getValue());
    }

    public void testBeanScopeSingleton() {
        SingletonScopeExampleBean beanOne = (SingletonScopeExampleBean) appContext.getBean("singletonScopeExampleBean");
        SingletonScopeExampleBean beanTwo = (SingletonScopeExampleBean) appContext.getBean("singletonScopeExampleBean");
        beanOne.setValue("VALUE ONE");
        beanTwo.setValue("VALUE TWO");

        log.info(beanOne.getValue());
        log.info(beanTwo.getValue());
    }
}
