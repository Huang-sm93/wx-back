package com.example.wx.appbackend.user.controller;

import com.example.wx.appbackend.common.ServiceData;
import com.example.wx.appbackend.user.entity.UserPageDto;
import com.example.wx.appbackend.user.entity.UserReqDto;
import com.example.wx.appbackend.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/get")
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
