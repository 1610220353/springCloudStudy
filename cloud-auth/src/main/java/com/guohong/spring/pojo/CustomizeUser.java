package com.guohong.spring.pojo;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * @author guohong
 * 自定义用户类
 */
@Getter
public class CustomizeUser extends User{

    private String name;
    /**
     * 这儿可以随意增加数据，
     * @param username 密码
     * @param password 账号
     * @param authorities  权限的集合
     */
    public CustomizeUser(String name,String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.name = name;
    }

}
