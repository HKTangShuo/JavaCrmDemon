package com.kkb.crm.controller;

import com.kkb.crm.dto.LoginResult;
import com.kkb.crm.pojo.CrmUser;
import com.kkb.crm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    UserService service;

    @RequestMapping("/login")
    public String showLoginJsp() {
        return "login";
    }

    @PostMapping("/dologin")
    public String userLogin(HttpSession session, String usercode, String password, Model model) {
        LoginResult result = service.login(usercode, password);
        if (result.getUser() != null) {
            session.setAttribute("user", result.getUser());
            return "forward:/customerList";
        } else {
            model.addAttribute("msg", result.getMsg());
        }
        return "login";
    }
    @GetMapping("/dologout")
    public String  logout(HttpSession session){
        service.logout(session);
        return "login";
    }
}
