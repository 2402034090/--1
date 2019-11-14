package com.sunny.controller;

/**
 * @Classname CustomerController
 * @Description 微冷的雨训练营 www.cnblogs.com/weilengdeyu
 * @Date 2019/11/14 16:07
 * @Created by Happy-微冷的雨
 */

import com.sunny.common.ServerResponse;
import com.sunny.pojo.dto.CustomerDto;
import com.sunny.pojo.po.Customer;
import com.sunny.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 客户的控制器
 */
@RestController
public class CustomerController {
   //01.注入service的对象
    @Autowired
    private CustomerService customerService;

    //01.添加客户的方法
    @RequestMapping(value = "/customer",method = RequestMethod.POST)
    public ServerResponse<Customer> addCustomer(@Valid CustomerDto customer){
        customerService.addCustomer(customer);
        return ServerResponse.createBySuccessMessage("添加客户档案成功");
    }
}
