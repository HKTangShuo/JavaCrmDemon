package com.kkb.crm.service.impl;

import com.kkb.crm.dao.CrmUserMapper;
import com.kkb.crm.pojo.CrmUser;
import com.kkb.crm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    CrmUserMapper  userMapper;

    @Override
    public CrmUser getUserByID(Integer id) {
        return userMapper.selectByPrimaryKey(Long.valueOf(id));
    }
}

