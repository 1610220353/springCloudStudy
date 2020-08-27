package com.guohong.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author guohong
 */

@SpringBootApplication
@EnableDiscoveryClient
public class GateWayApplication {

    public static void main(String[] args) {
//        CustomizeApplication.run("haha",GateWayApplication.class,args);
        SpringApplication.run(GateWayApplication.class,args);

    }

}
