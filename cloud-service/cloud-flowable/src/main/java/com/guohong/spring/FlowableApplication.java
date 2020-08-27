package com.guohong.spring;

import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author guohong
 */
@SpringBootApplication
public class FlowableApplication {

    public static void main(String[] args) {
//        SpringApplication.run(FlowableApplication.class,args);
        CustomizeApplication.run("Flowable",FlowableApplication.class,args);
    }


}
