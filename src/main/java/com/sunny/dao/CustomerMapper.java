package com.sunny.dao;

import com.sunny.pojo.po.Customer;
import com.sunny.util.MyMapper;
import org.springframework.stereotype.Repository;

/**
 * 01.准备客户DAO接口
 */
@Repository
public interface CustomerMapper extends MyMapper<Customer> {
}