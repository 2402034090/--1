package com.sunny;

/**
 * @Classname SunnyApplication
 * @Description 微冷的雨训练营 www.cnblogs.com/weilengdeyu
 * @Date 2019/11/12 10:27
 * @Created by Happy-微冷的雨
 */

import com.sunny.shiro.JWTUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * SpringBoot启动类
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.sunny.dao"})
@EnableTransactionManagement
public class SunnyApplication {
    public static void main(String[] args) {
        SpringApplication.run(SunnyApplication.class,args);
    }
    @Bean
    public JWTUtil jwtUtil(){
        return new JWTUtil();
    }
}
