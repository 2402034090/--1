package com.sunny.service.impl;

import com.sunny.common.ServerResponse;
import com.sunny.dao.UserMapper;
import com.sunny.exception.IllegalException;
import com.sunny.pojo.bo.IdAndNameBo;
import com.sunny.pojo.dto.UserDto;
import com.sunny.pojo.po.User;
import com.sunny.pojo.vo.UserVo;
import com.sunny.service.UserService;
import com.sunny.shiro.JWTUtil;
import com.sunny.util.PasswordHelp;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Classname UserServiceImpl
 * @Description 微冷的雨训练营 www.cnblogs.com/weilengdeyu
 * @Date 2019/11/12 14:05
 * @Created by Happy-微冷的雨
 */
@Service
public class UserServiceImpl implements UserService {
    //01.获取日志对象
    Logger logger = LoggerFactory.getLogger(this.getClass());
    //02.植入DAO层接口对象
    @Autowired
    private UserMapper userMapper;

    //03.植入JWTUtil的对象
    @Autowired
    private JWTUtil jwtUtil;

    @Override
    public User findUserByUserNme(String username) {
        return userMapper.findUserByUserName(username);
    }

    @Override
    public ServerResponse loginUser(User vo) {
        if (StringUtils.isBlank(vo.getUserName()) || StringUtils.isBlank(vo.getUserPassword())) {
            throw new AuthenticationException("用户名或密码为空");
        }
        //根据用户名获取用户对象
        User user = findUserByUserNme(vo.getUserName());
        if (user == null) {
            throw new AuthenticationException("用户名不存在");
        }

        if (user.getDeleteStatus().equals("0")) { //1:正常状态   0:冻结状态
            throw new UnauthenticatedException("用户状态异常");
        }

        String inPassword = PasswordHelp.passwordSalt(vo.getUserName(), vo.getUserPassword()).toString();
        String dbPassword = user.getUserPassword(); //获取数据库中的密码

        if (!dbPassword.equals(inPassword)) {
            throw new AuthenticationException("密码不正确");
        }

 /*       user.setLastLoginIp(ip);
        //该方法可以修改单个字段
        userMapper.updateByPrimaryKeySelective(user);*/
        //为了去获取
        UserVo userVo = getUser(user);
        //返回
        return ServerResponse.createBySuccess(userVo);
    }

    private UserVo getUser(User user) {

        if (user == null) {
            throw new IllegalException("用户不存在");
        }

        //传值给前端封装类
        UserVo userVo = new UserVo(); //登录成功后显示的json对象
        Long userId = user.getId();   //获取用户编号
        BeanUtils.copyProperties(user, userVo); //将user对象中所有的属性复制到userVo对象中

        String token = jwtUtil.sign(userId, user.getUserName(), user.getUserPassword(), user.getStoreId());
        userVo.setToken(token);
        return userVo;
    }

    @Override
    public ServerResponse<IdAndNameBo> addEmployee(UserDto userDto) {

        logger.info("进入addEmployee方法" + userDto);

        /*Long userId = jwtUtil.getUserId(); //获取用户编号
        Long storeId = jwtUtil.getStoreId(); //获取仓库编号*/

       /* if (userId == null || storeId == null) {
            throw new IllegalException("用户Id或店铺Id为空");
        }*/
        if (StringUtils.isBlank(userDto.getUserName()) || StringUtils.isBlank(userDto.getUserPassword())) {
            throw new IllegalException("添加员工信息不完善（用户名，密码不为空）");
        }

        //密码加密
        userDto.setUserPassword(PasswordHelp.passwordSalt(userDto.getUserName(), userDto.getUserPassword()));

        User user = new User();
        BeanUtils.copyProperties(userDto, user);
       /* user.setStoreId(78L);
        user.setOperator(175L);*/
        try {
            //核心代码  hibernate
            userMapper.insertSelective(user);
        } catch (Exception e) {
            throw new IllegalException("添加失败"+e.getMessage());
        }
        //构建对象
        IdAndNameBo idAndNameBo = new IdAndNameBo(user.getId(), user.getUserName());
        ServerResponse serverResponse = ServerResponse.createBySuccess("添加成功", idAndNameBo);
        logger.info("退出addEmployee方法" + serverResponse);
        return serverResponse;
    }

}
