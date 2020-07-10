package com.guohong.spring.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author guohong
 */
@Data
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户基础信息
     */
    private User user;

    /**
     * 权限标识集合
     */
    private List<String> permissions;

    /**
     * 角色集合
     */

    private List<String> roles;
}
