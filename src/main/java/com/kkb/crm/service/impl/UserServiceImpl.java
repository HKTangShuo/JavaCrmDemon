package com.kkb.crm.service.impl;

import com.kkb.crm.dao.CrmUserMapper;
import com.kkb.crm.dto.LoginResult;
import com.kkb.crm.pojo.CrmUser;
import com.kkb.crm.pojo.CrmUserExample;
import com.kkb.crm.service.UserService;
import com.mysql.cj.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    CrmUserMapper userMapper;

    @Override
    public CrmUser getUserByID(Integer id) {
        return userMapper.selectByPrimaryKey(Long.valueOf(id));
    }

    @Override
    public LoginResult login(String usercode, String password) {
        String encrypt_password = DigestUtils.md5DigestAsHex(password.getBytes());

        LoginResult result = new LoginResult();
        if (StringUtils.isNullOrEmpty(usercode) && StringUtils.isNullOrEmpty(password)) {

        } else {
            CrmUserExample example = new CrmUserExample();
            CrmUserExample.Criteria criteria = example.createCriteria();
            criteria.andUserCodeEqualTo(usercode).andUserPasswordEqualTo(encrypt_password);
            List<CrmUser> crmUser = userMapper.selectByExample(example);
            System.out.println(crmUser);
            if (crmUser.size() > 0) {
                result.setUser(crmUser.get(0));
            } else {
                result.setMsg("wrong username or password");
            }
        }
        return result;
    }

    @Override
    public void logout(HttpSession session) {
        session.removeAttribute("user");

    }
}

