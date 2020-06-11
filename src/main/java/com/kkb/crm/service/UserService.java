package com.kkb.crm.service;

import com.kkb.crm.dto.LoginResult;
import com.kkb.crm.pojo.CrmUser;

import javax.servlet.http.HttpSession;

public interface UserService {
    CrmUser getUserByID(Integer id);

    LoginResult login(String usercode, String password);

    void logout(HttpSession session);

}
