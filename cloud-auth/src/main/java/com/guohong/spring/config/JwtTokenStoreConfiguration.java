package com.guohong.spring.config;

import com.guohong.spring.support.JwtTokenEnhancer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import java.util.Properties;

/**
 * @author guohong
 */
@Configuration
public class JwtTokenStoreConfiguration {


    @Autowired
    public RedisConnectionFactory redisConnectionFactory;

    /**
     * jwt的token存储对象
     * RedisTokenStore 使用RedisTokenStore token永远是一个
     * 使用JwtTokenStore 每次都会自动刷新
     */
    @Bean
    public TokenStore jwtTokenStore(){
//        RedisTokenStore redisTokenStore = new RedisTokenStore(redisConnectionFactory);
//        //设置redis token存储中的前缀
//        redisTokenStore.setPrefix("access_token:");
//        return redisTokenStore;
        return new JwtTokenStore(jwtAccessTokenConverter());
    }


    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter(){
        JwtAccessTokenConverter accessTokenConverter = new JwtAccessTokenConverter();


        accessTokenConverter.setSigningKey("hah");
        return accessTokenConverter;
    }



    /**
     * jwt 增强 也就自定义返回值
     * @return
     */
    @Bean
    public TokenEnhancer jwtTokenEnhancer() {

        return new JwtTokenEnhancer();
    }
}
