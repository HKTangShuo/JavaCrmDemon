package com.kkb.crm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kkb.crm.dao.CrmCustomerMapper;
import com.kkb.crm.dao.CrmDictMapper;
import com.kkb.crm.dto.CustomerQuery;
import com.kkb.crm.pojo.CrmCustomer;
import com.kkb.crm.pojo.CrmCustomerExample;
import com.kkb.crm.service.CustomerService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CrmCustomerMapper crmCustomerMapper;
    @Autowired
    private CrmDictMapper dictMapper;

    @Override
    public PageInfo selectCustomerList(CustomerQuery customerQuery) {

        //根据查询对象  进行条件查询
        CrmCustomerExample crmCustomerExample = new CrmCustomerExample();
        CrmCustomerExample.Criteria criteria = crmCustomerExample.createCriteria();

        //名称
        if (StringUtils.isNotEmpty(customerQuery.getCustName())) {
            criteria.andCustNameLike("%" + customerQuery.getCustName() + "%");
        }
        //行业
        if (StringUtils.isNotEmpty(customerQuery.getCustIndustry())) {
            criteria.andCustIndustryEqualTo(customerQuery.getCustIndustry());
        }
        //来源
        if (StringUtils.isNotEmpty(customerQuery.getCustSource())) {
            criteria.andCustSourceEqualTo(customerQuery.getCustSource());
        }
        //级别
        if (StringUtils.isNotEmpty(customerQuery.getCustLevel())) {
            criteria.andCustLevelEqualTo(customerQuery.getCustLevel());
        }


        // 启用分页插件
        PageHelper.startPage(customerQuery.getPageNum(), customerQuery.getPageSize());
        List<CrmCustomer> crmCustomerList = crmCustomerMapper.selectByExample(crmCustomerExample);
        PageInfo<CrmCustomer> pageInfo = new PageInfo<>(crmCustomerList);


        for (CrmCustomer crmcustomer : crmCustomerList
        ) {
            String fromtype = dictMapper.selectByPrimaryKey(crmcustomer.getCustSource()).getDictItemName();
            String level = dictMapper.selectByPrimaryKey(crmcustomer.getCustLevel()).getDictItemName();
            String industry = dictMapper.selectByPrimaryKey(crmcustomer.getCustIndustry()).getDictItemName();
            crmcustomer.setCustIndustry(industry);
            crmcustomer.setCustSource(fromtype);
            crmcustomer.setCustLevel(level);
        }
        return pageInfo;
    }

    @Override
    public CrmCustomer selectUserById(Integer id) {

        return crmCustomerMapper.selectByPrimaryKey(id.longValue());
    }

    @Override
    public void updateUser(CrmCustomer crmCustomer) {


        crmCustomerMapper.updateByPrimaryKey(crmCustomer);
    }

    @Override
    public void DeleteUser(Integer id) {

        crmCustomerMapper.deleteByPrimaryKey(Long.valueOf(id));
    }
}
