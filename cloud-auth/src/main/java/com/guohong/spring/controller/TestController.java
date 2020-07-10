package com.guohong.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guohong
 */
@RestController
public class TestController {


    @GetMapping(value = "test")
    public String getTest() {

        return "sess";
    }

}
