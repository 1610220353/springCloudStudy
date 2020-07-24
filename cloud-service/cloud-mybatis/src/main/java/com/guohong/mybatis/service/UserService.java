package com.guohong.mybatis.service;

import com.guohong.mybatis.mapper.TestMapper;
import com.guohong.mybatis.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    @Autowired
    private TestMapper testMapper;



    public List<User> findAll() {

        return testMapper.selectAll();
    }
}
