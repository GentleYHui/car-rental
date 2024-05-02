package com.yhui.bus.service;

import com.yhui.bus.domain.Customer;
import com.yhui.bus.vo.CustomerVo;
import com.yhui.sys.utils.DataGridView;

public interface ICustomerService {
    DataGridView queryAllCustomer(CustomerVo customerVo);

    void addCustomer(CustomerVo customerVo);

    void deleteCustomer(String identity);

    void updateCustomer(CustomerVo customerVo);

    void deleteBatchCustomer(String[] ids);

    Customer queryCustomerByIdentity(String identity);
}
