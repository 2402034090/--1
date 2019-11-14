package com.sunny.controller;

import com.sunny.common.ServerResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Classname BaseExceptionHandler
 * @Description 微冷的雨训练营 www.cnblogs.com/weilengdeyu
 * @Date 2019/4/19 17:11
 * @Created by Happy-微冷的雨
 */
@ControllerAdvice
public class BaseExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ServerResponse error(Exception ex){
        ex.printStackTrace();
        return  ServerResponse.createBySuccessCodeMessages(1,ex.getMessage());
    }
}