package com.kkb.crm.service;

import com.github.pagehelper.PageInfo;
import com.kkb.crm.dto.CustomerQuery;
import com.kkb.crm.pojo.CrmCustomer;

public interface CustomerService {
    PageInfo selectCustomerList(CustomerQuery customerQuery);

    CrmCustomer selectUserById(Integer id);

    void updateUser(CrmCustomer crmCustomer);

    void DeleteUser(Integer id);
}
