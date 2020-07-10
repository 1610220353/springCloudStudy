package com.guohong.spring.service;

import lombok.SneakyThrows;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * @author guohong
 *
 *基于 JDBC 实现，需要事先在数据库配置客户端信息
 */
@Component
public class ClientDetailsServiceImpl extends JdbcClientDetailsService {
    public ClientDetailsServiceImpl(DataSource dataSource) {
        super(dataSource);
    }

    /**
     * 缓存客户端信息
     *
     * @param clientId 客户端id
     */
    @Override
    @SneakyThrows
    public ClientDetails loadClientByClientId(String clientId) {
        return super.loadClientByClientId(clientId);
    }

}
