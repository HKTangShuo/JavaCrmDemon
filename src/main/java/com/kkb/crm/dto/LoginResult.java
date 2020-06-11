package com.kkb.crm.dto;

import com.kkb.crm.pojo.CrmUser;

public class LoginResult {
    private CrmUser user;
    private String msg;

    @Override
    public String toString() {
        return "LoginResult{" +
                "user=" + user +
                ", msg='" + msg + '\'' +
                '}';
    }

    public CrmUser getUser() {
        return user;
    }

    public void setUser(CrmUser user) {
        this.user = user;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
