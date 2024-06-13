package com.wx.appbackend.controller;

import com.wx.appbackend.common.ServiceData;
import com.wx.appbackend.service.user.entity.UserResDto;
import com.wx.appbackend.service.user.entity.UserReqDto;
import com.wx.appbackend.service.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/user")
@Api(value = "用户管理")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/get")
    @ApiOperation(value = "获取用户信息")
    public ServiceData<UserResDto> get(@RequestParam("id") Long id)throws Exception{
        ServiceData sd = new ServiceData();
        sd.setBo(userService.get(id));
        return sd;
    }

    @PostMapping("/getpage")
    public ServiceData<List<UserResDto>> getPage(@RequestBody UserReqDto reqDto)throws Exception{
        ServiceData sd = new ServiceData();
        sd.setBo(userService.getPage(reqDto));
        return sd;
    }

    @PostMapping("/save")
    public ServiceData save(@RequestBody UserReqDto user)throws Exception{
        ServiceData sd = new ServiceData();
        if (user.id != null && user.id > 0){
            sd.setBo(userService.update(user));
        }else {
            sd.setBo(userService.insert(user));
        }
        return sd;
    }
}
