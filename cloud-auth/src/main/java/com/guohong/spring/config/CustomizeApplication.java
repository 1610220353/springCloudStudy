package com.guohong.spring.config;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author guohong
 * 自定义启动 springBoot 项目
 */
public class CustomizeApplication {

    public CustomizeApplication(){

    }
    public static ConfigurableApplicationContext run(String appName, Class source, String... args) {
        SpringApplicationBuilder builder = createSpringApplicationBuilder(appName, source, args);
        return builder.run(args);
    }

    public static SpringApplicationBuilder createSpringApplicationBuilder(String appName, Class source, String... args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(new Class[]{source});
        System.out.println("asgh");
        return builder;
    }
}
