package com.guohong.mybatis;




import com.guohong.spring.CustomizeApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;


/**
 * @author guohong
 *
 */
@SpringBootApplication
@MapperScan(value = "com.guohong.mybatis.mapper")
public class SpringMybatisApplication {
    public static void main(String[] args) {
        CustomizeApplication.run("mybatis",SpringMybatisApplication.class,args);

    }
}
