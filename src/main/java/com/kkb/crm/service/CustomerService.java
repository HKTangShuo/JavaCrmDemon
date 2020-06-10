package com.kkb.crm.service;

import com.github.pagehelper.PageInfo;
import com.kkb.crm.dto.CustomerQuery;

public interface CustomerService {
    PageInfo selectCustomerList(CustomerQuery customerQuery);
}
