package com.guohong.cloud.controller;

import com.guohong.cloud.config.SerialCloneUtils;
import org.redisson.api.RedissonClient;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: guohong
 * @date: 2022/1/10
 **/

public class TestController {


    private RedissonClient redissonClient;


    public void sendMessage(Object value) {

        System.out.println(value);
    }

    public static void main(String[] args) {
        Map<String,Object> data = new HashMap<>();
        Map<String,Object> data1 = new HashMap<>();
        Map<String,Object> data2 = new HashMap<>();

        data2.put("data3","haha");
        data1.put("data2",data2);
        data.put("data1",data1);


        Map map = SerialCloneUtils.deepClone(data);



        ((Map)((Map)map.get("data1")).get("data2")).put("data111","11");
        System.out.println(map);
        System.out.println(data);

        String a = "[{\"dd\":55}]";

        TestController testController = new TestController();

        testController.sendMessage(a);

    }
}
