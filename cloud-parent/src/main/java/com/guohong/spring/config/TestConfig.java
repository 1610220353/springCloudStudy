package com.guohong.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 类描述:
 *
 * @author: guohong
 * @date: 2020-08-25 10:37
 */
@Configuration
public class TestConfig {
    @Bean
    public String springUtil() {
        return "new SpringUtil()";
    }
}
