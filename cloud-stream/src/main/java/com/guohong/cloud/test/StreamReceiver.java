package com.guohong.cloud.test;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: guohong
 * @date: 2022/1/10
 **/
@Component
@EnableBinding(StreamClient.class)  // 定义的接口类
public class StreamReceiver {


   @StreamListener(value = StreamClient.INPUT)
    public void process(Object message) {
       System.out.println(message);
   }


    @StreamListener(value = StreamClient.INPUT2)
    @SendTo(value = StreamClient.INPUT2)
    public String process2(Object message) {
        System.out.println(message);
        return "ok";
    }


}
