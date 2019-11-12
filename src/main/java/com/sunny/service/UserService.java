package com.sunny.service;

/**
 * @Classname UserService
 * @Description 微冷的雨训练营 www.cnblogs.com/weilengdeyu
 * @Date 2019/11/12 11:29
 * @Created by Happy-微冷的雨
 */

import com.sunny.common.ServerResponse;
import com.sunny.pojo.bo.IdAndNameBo;
import com.sunny.pojo.dto.UserDto;
import com.sunny.pojo.po.User;

/**
 * 用户service接口层
 */
public interface UserService {

    //01.根据用户名查询用户实体
    User findUserByUserNme(String username);

    /**
     * 02.用户登录
     * @param userName  用户名
     * @param password  密码
     * @param ip        ip地址
     * @return
     */
    ServerResponse loginUser(String userName, String password, String ip);

    /**
     * 03.添加员工
     * @param userDto  用户对象
     * @return
     */
    ServerResponse<IdAndNameBo> addEmployee(UserDto userDto);


}
