package com.guohong.spring.config;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.Properties;

/**
 * @author guohong
 */
@Configuration
public class TestConfig implements BeanPostProcessor {
    @PostConstruct
    public void test(){
        Properties props = System.getProperties();
        props.setProperty("test","hahhah");
    }
}
