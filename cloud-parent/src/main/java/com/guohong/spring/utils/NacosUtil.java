package com.guohong.spring.utils;

import com.alibaba.nacos.api.config.ConfigFactory;
import com.alibaba.nacos.api.config.ConfigService;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Properties;

public class NacosUtil {
	private String serverAddr;

	public String default_group = null;


	public NacosUtil() {
		Properties props = System.getProperties();
//		this.serverAddr = props.getProperty("spring.cloud.nacos.config.server-addr");

	}

	public String getNaCosValue(String dataId,String group,String key) throws Exception {
		ConfigService configService = ConfigFactory.createConfigService("127.0.0.1:8848");
		default_group = configService.getConfig(dataId, group, 5000);
		Properties load = load(default_group);
		return load.getProperty(key);
	}

	public Properties load(String propertiesString) {
		Properties properties = new Properties();
		try {
			properties.load(new ByteArrayInputStream(propertiesString.getBytes()));
		} catch (IOException e) {
			return null;
		}
		return properties;
	}
}
