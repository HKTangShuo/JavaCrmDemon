package com.kkb.crm.service;

import com.kkb.crm.dto.CustomerQuery;
import com.kkb.crm.pojo.CrmCustomer;

import java.util.List;

public interface CustomerService {
    List<CrmCustomer> selectCustomerList(CustomerQuery customerQuery);
}
