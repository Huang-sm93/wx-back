package com.wx.appbackend.user.controller;


import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(tags = "登录页面")
@Controller
public class LoginController {


    @RequestMapping("/login")
    public String login()throws Exception{
        return "index";
    }
}
