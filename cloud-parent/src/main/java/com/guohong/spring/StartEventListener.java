package com.guohong.spring;

import com.guohong.spring.utils.NacosUtils;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.Async;
import org.springframework.util.StringUtils;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.Objects;

/**
 * @author guohong
 * 启动之后
 */
@Configuration
public class StartEventListener {

    private static final Logger log = LoggerFactory.getLogger(StartEventListener.class);

    public StartEventListener() {
    }


    @Async
    @Order
    @SneakyThrows
    @EventListener({WebServerInitializedEvent.class})
    public void afterStart(WebServerInitializedEvent event) {
        Environment environment = event.getApplicationContext().getEnvironment();
        String appName = Objects.requireNonNull(environment.getProperty("spring.application.name")).toUpperCase();
        String serverAddr = Objects.requireNonNull(environment.getProperty("spring.cloud.nacos.discovery.server-addr")).toUpperCase();
        int localPort = event.getWebServer().getPort();
        String profile = StringUtils.arrayToCommaDelimitedString(environment.getActiveProfiles());
        String serverIp = Inet4Address.getLocalHost().getHostAddress();


        log.info("正在加载nacos，地址为[{}]，即将注册[{}],IP为[{}]",serverAddr,appName,serverIp);

        NacosUtils nacosUtils = new NacosUtils(serverAddr,serverIp,localPort,appName,true);
        nacosUtils.upNacos();

        log.info("---[{}]---启动完成，当前使用的端口:[{}]，环境变量:[{}]---", appName, localPort, profile);



    }
}
