package com.guohong.spring.service;

import com.guohong.spring.pojo.CustomizeUser;
import com.guohong.spring.pojo.UserInfo;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author guohong
 * 自定义请求数据库认证
 */
@Service(value = "userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {


    @Override
    public CustomizeUser loadUserByUsername(String s) throws UsernameNotFoundException {

        if ("a".equals(s)) {
            UserInfo userInfo = new UserInfo();
            List<String> roles =new ArrayList<>();
            roles.add("123456");
            return new CustomizeUser("测试", s, "123456", AuthorityUtils.commaSeparatedStringToAuthorityList(StringUtils.collectionToCommaDelimitedString(roles)));
        } else {
            //这个地方的数据一般是使用 service层返回的数据 msg
            throw new UsernameNotFoundException("登录失败");
        }


    }
}
