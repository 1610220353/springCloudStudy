package com.guohong.spring.controller;

import com.guohong.spring.model.Blog;
import com.guohong.spring.rpc.IBlogRpc;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Blog控制器
 *
 * @author Chill
 */
@RestController
@RequestMapping("blog")
public class BlogController {

    /**
     * //check  当项目启动时会自动检查其依赖的服务是否开启,如果没开是会阻止spring的初始化的,即check=true
     * 	//超时(timeout,默认为1000)，重试次数(retries)
     * stub(本地存根) 正常情况下,服务搭建成功后服务的实现一般都在服务端,但有时候我们可能需要在客户端做些逻辑操作,
     * 	比如参数验证,缓存处理以及调用失败后伪造容错数据的处理等等,这时候我们就需要用到dubbo的本地存根机制,他能在远程服务调用前在客户端进行相关的逻辑操作
     */
    @Reference(
            version = "1.0.0",
            mock = "com.guohong.spring.rpc.BlogMock",
            stub = "com.guohong.spring.rpc.BlogStub",
            check = false
    )
    private IBlogRpc rpc;

    @GetMapping("detail/{id}")
    public Map<String, Blog> detail(@PathVariable Integer id) {
        Blog detail = rpc.detail(id);
        Map<String, Blog> map = new HashMap<>();

        map.put("测试成功", detail);
        return map;
    }

}
