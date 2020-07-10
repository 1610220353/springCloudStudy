package com.guohong.spring.utils;

/**
 * @author guohong
 */
public interface NacosConstant {

    String NACOS_ADDR = "127.0.0.1:8848";
    String NACOS_CONFIG_PREFIX = "blade";
    String NACOS_GROUP_SUFFIX = "-group";
    String NACOS_CONFIG_FORMAT = "yaml";
    String NACOS_CONFIG_JSON_FORMAT = "json";
    String NACOS_CONFIG_REFRESH = "true";
    String NACOS_CONFIG_GROUP = "DEFAULT_GROUP";
    String NACOS_SEATA_GROUP = "SEATA_GROUP";

    static String dataId(String appName, String profile) {
        return dataId(appName, profile, "yaml");
    }

    static String dataId(String appName, String profile, String format) {
        return appName + "-" + profile + "." + format;
    }

    static String sharedDataIds(String profile) {
        return "blade.yaml,blade-" + profile + "." + "yaml";
    }
}
