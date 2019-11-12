package com.sunny.util;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/*
*Author:zhangxin_an
*Description:
*Data:Created in 22:52 2018/4/9
*/

/**
 * 密码加密工具类
 */
public class PasswordHelp {
    /**
     * 加密方法
     * @param userName  用户名
     * @param password  密码
     * @return
     */
    public static String passwordSalt(String userName, Object password) {
        String hashAlgorithmName = "MD5";//加密方式
        ByteSource salt = ByteSource.Util.bytes(userName);//以账号作为盐值
        int hashIterations = 1024;//加密1024次
        return new SimpleHash(hashAlgorithmName, password, salt, hashIterations).toString();
    }

    //测试加密
    public static void main(String[] args) {
        System.out.println(passwordSalt("happy","12345"));
    }

}
