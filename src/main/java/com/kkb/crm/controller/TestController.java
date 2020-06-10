package com.kkb.crm.controller;

import com.kkb.crm.pojo.CrmUser;
import com.kkb.crm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

    @Autowired
    UserService service;

    @RequestMapping("/text")
    public String test(Model model){
        CrmUser user = service.getUserByID(5);
        model.addAttribute("user",user);
        return "index";
    }
}
