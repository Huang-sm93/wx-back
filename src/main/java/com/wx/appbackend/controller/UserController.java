package com.wx.appbackend.controller;

import com.wx.appbackend.common.ServiceData;
import com.wx.appbackend.service.user.entity.UserPageDto;
import com.wx.appbackend.service.user.entity.UserReqDto;
import com.wx.appbackend.service.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/users")
@Api(value = "用户管理")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/get")
    @ApiOperation(value = "获取用户信息")
    public ServiceData<UserPageDto> getUser(@RequestParam("id") Long id)throws Exception{
        ServiceData sd = new ServiceData();
        sd.setBo(userService.get(id));
        return sd;
    }

    @PostMapping("/getpage")
    public ServiceData<List<UserPageDto>> getUser(@RequestBody Map<String, Object> map)throws Exception{
        ServiceData sd = new ServiceData();
        sd.setBo(userService.getPage(map));
        return sd;
    }

    @PostMapping("/save")
    public ServiceData save(@RequestBody UserReqDto user)throws Exception{
        ServiceData sd = new ServiceData();
        if (user.getId() != null){
            sd.setBo(userService.update(user));
        }else {
            sd.setBo(userService.insert(user));
        }
        return sd;
    }
}
