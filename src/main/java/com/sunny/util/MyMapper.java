package com.sunny.util;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @Classname MyMapper
 * @Description 微冷的雨训练营 www.cnblogs.com/weilengdeyu
 * @Date 2019/11/12 11:11
 * @Created by Happy-微冷的雨
 */
public interface MyMapper<T>  extends Mapper<T>,MySqlMapper<T> {


}
