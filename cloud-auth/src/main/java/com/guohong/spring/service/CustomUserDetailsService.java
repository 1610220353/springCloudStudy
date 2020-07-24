package com.guohong.spring.service;

import com.guohong.spring.pojo.CustomizeUser;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.common.exceptions.InvalidGrantException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author guohong
 *
 */
@Service(value = "customUserDetailsService")
public class CustomUserDetailsService {

    public CustomizeUser loadUserByPhoneAndPassword(String phone, String password) {
        if (StringUtils.isEmpty(phone) || StringUtils.isEmpty(password)) {
            throw new InvalidGrantException("无效的手机号或短信验证码");
        }
        List<String> roles =new ArrayList<>();
        roles.add("123456");
        // 判断成功后返回用户细节
        return new CustomizeUser("测试", phone, "", AuthorityUtils.commaSeparatedStringToAuthorityList(StringUtils.collectionToCommaDelimitedString(roles)));

    }

    public CustomizeUser loadUserByPhoneAndSmsCode(String phone, String smsCode) {
        if (StringUtils.isEmpty(phone) || StringUtils.isEmpty(smsCode)) {
            throw new InvalidGrantException("无效的手机号或短信验证码");
        }
        List<String> roles =new ArrayList<>();
        roles.add("123456");
        // 判断成功后返回用户细节
        return new CustomizeUser("测试", phone, "", AuthorityUtils.commaSeparatedStringToAuthorityList(StringUtils.collectionToCommaDelimitedString(roles)));
    }
}
