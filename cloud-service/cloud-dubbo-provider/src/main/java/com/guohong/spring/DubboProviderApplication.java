package com.guohong.spring;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 类描述:
 *
 * @author: guohong
 * @date: 2020-08-26 18:02
 */
@EnableDubbo
@SpringBootApplication
public class DubboProviderApplication {

    public static void main(String[] args) {
        CustomizeApplication.run("dubboApplication", DubboProviderApplication.class,args);
    }
}
