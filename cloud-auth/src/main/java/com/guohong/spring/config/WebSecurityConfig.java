package com.guohong.spring.config;


import com.guohong.spring.support.CustomizePasswordEncoder;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author guohong
 */
@Configuration
@AllArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {



    @Bean
    @Override
    @SneakyThrows
    public AuthenticationManager authenticationManagerBean() {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        //密码加密方式
        return new CustomizePasswordEncoder();
    }


    /**
     * @param http SneakyThrows 内置注解 用于抛出异常
     * HTTP基础认证（BA）是一种简单的认证机制。
     * 当一个web客户端需要保护任何web资源的时候，服务器会发送一个带有401状态码（未授权）的HTTP回应，
     * 还有类似WWW-Authenticate: Basic realm=”realm here” 的 WWW-Authenticate HTTP头。
     * 而浏览器这时候就会弹出一个登录对话框，提示输入用户名和密码。
     */
    @Override
    @SneakyThrows
    protected void configure(HttpSecurity http) {
        http.httpBasic().and().csrf().disable();
    }
}
