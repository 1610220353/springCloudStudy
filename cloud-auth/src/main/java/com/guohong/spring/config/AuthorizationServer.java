package com.guohong.spring.config;

import com.guohong.spring.constant.AuthConstant;
import com.guohong.spring.granter.CustomizeTokenGranter;
import com.guohong.spring.service.ClientDetailsServiceImpl;
import com.guohong.spring.service.CustomUserDetailsService;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.TokenGranter;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author guohong
 * 认证服务器配置
 */

@Configuration
@EnableAuthorizationServer
public class AuthorizationServer extends AuthorizationServerConfigurerAdapter {

    @Resource(name = "dataSourceTest")
    private DataSource dataSource;

    @Resource(name = "authenticationManagerBean")
    private AuthenticationManager authenticationManager;


    @Resource(name = "jwtTokenStore")
    private TokenStore tokenStore;

    @Resource(name = "jwtAccessTokenConverter")
    private JwtAccessTokenConverter jwtAccessTokenConverter;

    @Resource(name = "userDetailsServiceImpl")
    private UserDetailsService userDetailsService;

    @Resource(name = "jwtTokenEnhancer")
    private TokenEnhancer jwtTokenEnhancer;

    @Resource(name = "customUserDetailsService")
    private CustomUserDetailsService customUserDetailsService;

    /**
     * 配置授权（authorization）以及令牌（token）的访问端点和令牌服务(token services)。
     *
     * @param endpoints
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        //获取自定义tokenGranter
        TokenGranter tokenGranter = CustomizeTokenGranter.getTokenGranter(authenticationManager, endpoints,customUserDetailsService);
        endpoints
                // 用于支持密码模式
                .authenticationManager(authenticationManager)
                .tokenStore(tokenStore)
                //自定义验证方式
                .userDetailsService(userDetailsService)
                .tokenGranter(tokenGranter);

        //扩展token返回结果
        if (jwtAccessTokenConverter != null && jwtTokenEnhancer != null) {
            TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
            List<TokenEnhancer> enhancerList = new ArrayList<>();
            enhancerList.add(jwtTokenEnhancer);
            enhancerList.add(jwtAccessTokenConverter);
            tokenEnhancerChain.setTokenEnhancers(enhancerList);
            //jwt增强
            endpoints.tokenEnhancer(tokenEnhancerChain).accessTokenConverter(jwtAccessTokenConverter);
        }

    }
    /**
     * 自定义验证规则
     *
     * @param clients
     */
    @SneakyThrows
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) {

        ClientDetailsServiceImpl clientDetailsService = new ClientDetailsServiceImpl(dataSource);
        clientDetailsService.setSelectClientDetailsSql(AuthConstant.DEFAULT_SELECT_STATEMENT);
        clientDetailsService.setFindClientDetailsSql(AuthConstant.DEFAULT_FIND_STATEMENT);
        clients.withClientDetails(clientDetailsService);
    }

    /**
     * 配置令牌端点(Token Endpoint)的安全约束
     *
     * @param oauthServer
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) {
        oauthServer
                //允许客户端使用表单进行验证
                .allowFormAuthenticationForClients()
                //开启/oauth/token_key验证端口无权限访问
                .tokenKeyAccess("permitAll()")
                // 允许客户端访问 /oauth/check_token 检查 token
                .checkTokenAccess("isAuthenticated()");
    }

}
