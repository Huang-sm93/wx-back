package com.wx.appbackend.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(tags = "登录页面")
@Controller
public class LoginController {


    @ApiOperation(value = "登录页面")
    @RequestMapping("/login")
    public String login()throws Exception{
        return "index";
    }
}
