package com.guohong.spring.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guohong
 */
@RestController
@RequestMapping("gateWay")
public class GateWayController {


    @GetMapping(value = "test")
    public String getTest() {
        return "sess";
    }
}
