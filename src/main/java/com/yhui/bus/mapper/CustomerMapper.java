package com.yhui.bus.mapper;

import com.yhui.bus.domain.Customer;
import com.yhui.bus.vo.CustomerVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


public interface CustomerMapper {
    List<Customer> queryAllCustomer(CustomerVo customerVo);

    void insertSelective(CustomerVo customerVo);

    void deleteCustomer(String identity);

    void updateCustomer(CustomerVo customerVo);

    Customer selectByPrimaryKey(String identity);
}
