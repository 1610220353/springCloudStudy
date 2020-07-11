package com.guohong.spring.service;


import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.core.Ordered;

/**
 * @author guohong
 */
public interface LauncherService extends Ordered, Comparable<LauncherService> {

    void launcher(SpringApplicationBuilder builder, String appName, String profile, boolean isLocalDev);

    @Override
    default int getOrder() {
        return 0;
    }

    @Override
    default int compareTo(LauncherService o) {
        return Integer.compare(this.getOrder(), o.getOrder());
    }
}
