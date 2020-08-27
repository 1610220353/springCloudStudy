package com.guohong.spring;



import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author guohong
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SpringStudyApplication {
    public static void main(String[] args) {
        CustomizeApplication.run("test",SpringStudyApplication.class,args);

    }
}
