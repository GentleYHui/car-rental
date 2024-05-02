package com.yhui.bus.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import com.yhui.bus.domain.Customer;
import com.yhui.bus.mapper.CustomerMapper;
import com.yhui.bus.service.ICustomerService;
import com.yhui.bus.vo.CustomerVo;
import com.yhui.sys.utils.DataGridView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    private CustomerMapper customerMapper;

    //分页查询客户信息
    @Override
    public DataGridView queryAllCustomer(CustomerVo customerVo) {
        Page<Object> page = PageHelper.startPage(customerVo.getPage(), customerVo.getLimit());
        List<Customer> data = customerMapper.queryAllCustomer(customerVo);
        return new DataGridView(page.getTotal(), data);
    }

    @Override
    public void deleteBatchCustomer(String[] ids) {
        for (String identity : ids) {
            this.deleteCustomer(identity);
        }
    }

    @Override
    public void addCustomer(CustomerVo customerVo) {
        customerMapper.insertSelective(customerVo);
    }

    @Override
    public void deleteCustomer(String identity) {
        customerMapper.deleteCustomer(identity);
    }

    @Override
    public void updateCustomer(CustomerVo customerVo) {
        customerMapper.updateCustomer(customerVo);
    }

    @Override
    public Customer queryCustomerByIdentity(String identity) {
        return customerMapper.selectByPrimaryKey(identity);
    }
}
