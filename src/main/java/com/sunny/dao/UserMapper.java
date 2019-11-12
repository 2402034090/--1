package com.sunny.dao;

/**
 * @Classname UserMapper
 * @Description 微冷的雨训练营 www.cnblogs.com/weilengdeyu
 * @Date 2019/11/12 11:08
 * @Created by Happy-微冷的雨
 */

import com.sunny.pojo.po.User;
import com.sunny.util.MyMapper;

/**
 * 用户DAO接口：base提炼
 */
public interface UserMapper extends MyMapper<User> {
   //根据主键查询单个对象
    //查看详情
   //根据用户名获取用户实体
   User findUserByUserName(String userName);
}
