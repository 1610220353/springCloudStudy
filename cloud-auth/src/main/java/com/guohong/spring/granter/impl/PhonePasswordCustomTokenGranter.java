package com.guohong.spring.granter.impl;

import com.guohong.spring.granter.AbstractCustomTokenGranter;
import com.guohong.spring.pojo.CustomizeUser;
import com.guohong.spring.service.CustomUserDetailsService;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.OAuth2RequestFactory;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;

import java.util.Map;

/**
 * @author guohong
 */
public class PhonePasswordCustomTokenGranter extends AbstractCustomTokenGranter {
    private static final String GRANT_TYPE = "test";

    //自定义用户认证
    private CustomUserDetailsService userDetailsService;

    public PhonePasswordCustomTokenGranter(CustomUserDetailsService userDetailsService, AuthorizationServerTokenServices tokenServices, ClientDetailsService clientDetailsService, OAuth2RequestFactory requestFactory) {
        super(tokenServices, clientDetailsService, requestFactory, GRANT_TYPE);
        this.userDetailsService = userDetailsService;


    }

    @Override
    protected CustomizeUser getUserDetails(Map<String, String> parameters) {

        String phone = parameters.get("phone");
        String password = parameters.get("password");

        return userDetailsService.loadUserByPhoneAndPassword(phone, password);
    }
}
