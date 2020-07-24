package com.guohong.mybatis.controller;

import com.guohong.mybatis.pojo.User;
import com.guohong.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "user")
public class Usercontroller {
    @Autowired
    private UserService testService;

    @GetMapping(value = "test")
    public void test() {

        List<User> all = testService.findAll();
        System.out.println(all);
    }

}
