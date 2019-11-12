package com.sunny.controller;

import com.sunny.common.ServerResponse;
import com.sunny.pojo.bo.IdAndNameBo;
import com.sunny.pojo.dto.UserDto;
import com.sunny.pojo.vo.UserVo;
import com.sunny.service.UserService;
import com.sunny.shiro.JWTUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * @Classname UserController
 * @Description 微冷的雨训练营 www.cnblogs.com/weilengdeyu
 * @Date 2019/11/12 14:50
 * @Created by Happy-微冷的雨
 */
@Api(tags = "用户模块")
@RestController
//用户的Controller
public class UserController {
    //日志对象
    Logger logger = LoggerFactory.getLogger(this.getClass());

    //植入Service对象
    @Autowired
    private UserService userService;

    //植入jwtUtil工具类
    @Autowired
    private JWTUtil jwtUtil;

    @PostMapping("/user/login")
    @ApiOperation(value = "用户登陆")
    public ServerResponse<UserVo> loginUser(String userName, String userPassword) {
        return userService.loginUser(userName, userPassword, "");
    }

    @PostMapping("/user/employee")
    @ApiOperation(value = "添加员工", notes = "添加员工并注册")
    @ApiResponses({@ApiResponse(code = 400, message = "所添加员工信息有误")})
    public ServerResponse<IdAndNameBo> addEmployee(@Valid UserDto userDto) {
        return userService.addEmployee(userDto);
    }
}
