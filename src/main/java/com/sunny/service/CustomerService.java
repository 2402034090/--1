package com.sunny.service;

import com.sunny.common.PageModel;
import com.sunny.pojo.dto.CustomerConditionDto;
import com.sunny.pojo.dto.CustomerDto;
import com.sunny.pojo.po.Customer;
/*
 客户的Service接口层
 */
public interface CustomerService {
    /**
     * 功能描述：客户列表
     * @param customerConditionDto  条件组合
     * @param pageModel  pageModel实例
     * @return
     */
    PageModel<Customer> getCustomerList(CustomerConditionDto customerConditionDto, PageModel pageModel);

    /**
     * 功能描述： 根据主键获取单个客户实体
     * @param customerId  客户编号
     * @return
     */
    Customer getCustomerById(Long customerId);

    /**
     * 功能描述：根据主键更改客户实体
     * @param customerId   客户编号
     * @param customerDto  客户对象
     */
    void updateCustomer(Long customerId, CustomerDto customerDto);

    /**
     * 功能描述：删除客户对象
     * @param customerId  客户编号
     */
    void deleteCustomerById(Long customerId);

    /**
     * 功能描述：添加客户实体
     * @param customerDto  客户实体对象
     */
    void addCustomer(CustomerDto customerDto);
}
