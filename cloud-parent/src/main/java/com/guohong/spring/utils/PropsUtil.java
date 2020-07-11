package com.guohong.spring.utils;

import org.springframework.util.StringUtils;

import java.util.Properties;

public class PropsUtil {

    public PropsUtil() {
    }

    public static void setProperty(Properties props, String key, String value) {
        if (StringUtils.isEmpty(props.getProperty(key))) {
            props.setProperty(key, value);
        }

    }
}
