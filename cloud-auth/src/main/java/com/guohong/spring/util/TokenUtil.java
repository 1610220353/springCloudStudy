/*
 *      Copyright (c) 2018-2028, Chill Zhuang All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are met:
 *
 *  Redistributions of source code must retain the above copyright notice,
 *  this list of conditions and the following disclaimer.
 *  Redistributions in binary form must reproduce the above copyright
 *  notice, this list of conditions and the following disclaimer in the
 *  documentation and/or other materials provided with the distribution.
 *  Neither the name of the dreamlu.net developer nor the names of its
 *  contributors may be used to endorse or promote products derived from
 *  this software without specific prior written permission.
 *  Author: Chill 庄骞 (smallchill@163.com)
 */
package com.guohong.spring.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.apache.commons.codec.Charsets;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.oauth2.common.exceptions.UnapprovedClientAuthenticationException;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Calendar;

/**
 * 认证工具类
 *
 * @author Chill
 */
public class TokenUtil {

    public final static String AVATAR = "avatar";
    public final static String ACCOUNT = "account";
    public final static String USER_NAME = "user_name";
    public final static String NICK_NAME = "nick_name";
    public final static String REAL_NAME = "real_name";
    public final static String USER_ID = "user_id";
    public final static String DEPT_ID = "dept_id";
    public final static String POST_ID = "post_id";
    public final static String ROLE_ID = "role_id";
    public final static String ROLE_NAME = "role_name";
    public final static String TENANT_ID = "tenant_id";
    public final static String CLIENT_ID = "client_id";
    public final static String LICENSE = "license";

    public final static String CAPTCHA_HEADER_KEY = "Captcha-Key";
    public final static String CAPTCHA_HEADER_CODE = "Captcha-Code";
    public final static String CAPTCHA_NOT_CORRECT = "验证码不正确";
    public final static String TENANT_HEADER_KEY = "Tenant-Id";
    public final static String TENANT_PARAM_KEY = "tenant_id";
    public final static String DEFAULT_TENANT_ID = "000000";
    public final static String TENANT_NOT_FOUND = "租户ID未找到";
    public final static String USER_TYPE_HEADER_KEY = "User-Type";
    public final static String DEFAULT_USER_TYPE = "web";
    public final static String USER_NOT_FOUND = "用户名或密码错误";
    public final static String USER_HAS_NO_ROLE = "未获得用户的角色信息";
    public final static String USER_HAS_NO_TENANT = "未获得用户的租户信息";
    public final static String USER_HAS_NO_TENANT_PERMISSION = "租户授权已过期,请联系管理员";
    public final static String HEADER_KEY = "Authorization";
    public final static String HEADER_PREFIX = "Basic ";
    public final static String DEFAULT_AVATAR = "";
	private static final String COLON = ":";

	private final static String BASE64_SECURITY = Base64.getEncoder().encodeToString("hah".getBytes(StandardCharsets.UTF_8));

	/**
     * 获取token过期时间(次日凌晨3点)
     *
     * @return expire
     */
    public static int getTokenValiditySecond() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, 1);
        cal.set(Calendar.HOUR_OF_DAY, 3);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return (int) (cal.getTimeInMillis() - System.currentTimeMillis()) / 1000;
    }

    /**
     * 获取refreshToken过期时间
     *
     * @return expire
     */
    public static int getRefreshTokenValiditySeconds() {
        return 60 * 60 * 24 * 15;
    }
    public static Claims parseJWT(String jsonWebToken) {
       return Jwts.parser().setSigningKey(Base64.getDecoder().decode(BASE64_SECURITY)).parseClaimsJws(jsonWebToken).getBody();
    }

    public static void main(String[] args) {
        Claims claims = TokenUtil.parseJWT("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJkYXRlIjoxNTk0MzUzNTE1MDUzLCJ1c2VyX25hbWUiOiJhIiwic2NvcGUiOlsiYWxsIl0sIm5hbWUiOiLmtYvor5UiLCJleHAiOjE1OTQzNTYxMTUsImF1dGhvcml0aWVzIjpbIjEyMzQ1NiJdLCJqdGkiOiJmMjNhOTc2YS1mMWFiLTQzYzctYTBjNi1kNjE1M2M4Mjg2NTMiLCJjbGllbnRfaWQiOiJzd29yZCJ9.zqdHwC19Ldso-B4g3MwKAvGbJm5GdBc0nhjtFcys8gI");
        System.out.println(claims);
//        Date date = claims.get("date", Date.class);
//        System.out.println(date.getTime());
//        Date date1 = new Date();
//        System.out.println(date1);
//        System.out.println(date1.getTime() > date.getTime());
    }

	public static String[] extractAndDecodeHeader(HttpServletRequest request) {

		String header = request.getHeader(TokenUtil.HEADER_KEY);

		if (header == null || !header.startsWith(TokenUtil.HEADER_PREFIX)) {
			throw new UnapprovedClientAuthenticationException("请求头中无client信息");
		}
		byte[] base64Token = header.substring(6).getBytes(Charsets.UTF_8);


		byte[] decoded;
		try {
			decoded = Base64.getDecoder().decode(base64Token);
		} catch (IllegalArgumentException var7) {
			throw new BadCredentialsException("Failed to decode basic authentication token");
		}

		String token = new String(decoded, Charsets.UTF_8);
		int index = token.indexOf(TokenUtil.COLON);
		if (index == -1) {
			throw new BadCredentialsException("Invalid basic authentication token");
		} else {
			return new String[]{token.substring(0, index), token.substring(index + 1)};
		}
	}
}
