package com.guohong.spring.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guohong
 */

@RestController
@RequestMapping(value = "expense")
@AllArgsConstructor
public class ExpenseController {

    @GetMapping(value = "hello1")
    public String hello() {


        return "hello";
    }

}
