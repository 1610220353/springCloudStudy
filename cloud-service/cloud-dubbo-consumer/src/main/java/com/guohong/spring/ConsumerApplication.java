package com.guohong.spring;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 类描述:
 *
 * @author: guohong
 * @date: 2020-08-27 10:17
 */
@EnableDubbo
@SpringBootApplication
public class ConsumerApplication {
    public static void main(String[] args) {
        CustomizeApplication.run("ConsumerApplication",ConsumerApplication.class,args);
    }
}
