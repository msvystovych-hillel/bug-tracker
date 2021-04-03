package com.example.demo.bpp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;

@Slf4j
//@Component
public class CustomBeanPostProcessor {
    //public class CustomBeanPostProcessor implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.info("Called postProcessBeforeInitialization() for :" + beanName);
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("Called postProcessAfterInitialization() for :" + beanName);
        return bean;
    }
}