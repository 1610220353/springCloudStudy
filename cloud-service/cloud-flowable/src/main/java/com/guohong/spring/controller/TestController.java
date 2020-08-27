package com.guohong.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * 类描述:
 *
 * @author: guohong
 * @date: 2020-08-21 19:07
 */

@RestController
@RequestMapping("/budget")
public class TestController {

    @Autowired
    private DataSource dataSource;

    @GetMapping("test")
    public void test() throws SQLException {
        System.out.println(dataSource.getConnection());
    }






}
