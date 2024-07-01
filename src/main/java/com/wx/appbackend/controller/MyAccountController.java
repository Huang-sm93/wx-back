package com.wx.appbackend.controller;

import com.wx.appbackend.common.RetCode;
import com.wx.appbackend.common.ServiceData;
import com.wx.appbackend.service.myaccount.MyAccountServiceImpl;
import com.wx.appbackend.service.myaccount.entity.MyAccountReqDTO;
import com.wx.appbackend.service.myaccount.entity.MyAccountResDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping(value = "/account")
@Api(tags = "我的账户信息")
public class MyAccountController {

    @Autowired
    private MyAccountServiceImpl myAccountService;

    @GetMapping("/get/{userId}")
    @ApiOperation(value = "获取账户记录")
    public ServiceData<MyAccountResDTO> getUser(@PathVariable Long userId)throws Exception{
        ServiceData sd = new ServiceData();
        sd.setBo(myAccountService.getByUserId(userId));
        return sd;
    }

    @PostMapping("/insert")
    @ApiOperation(value = "记录一条")
    public ServiceData<Integer> insert(@RequestBody MyAccountReqDTO reqDTO)throws Exception{
        ServiceData sd = new ServiceData();
        sd.setBo(myAccountService.insert(reqDTO));
        sd.setCode(RetCode.SUCCESS.toString());
        return sd;
    }

    @GetMapping("/delete")
    @ApiOperation(value = "删除一条记录")
    public ServiceData<MyAccountResDTO> get(@PathParam("id") Long id)throws Exception{
        ServiceData sd = new ServiceData();
        myAccountService.delete(id);
        sd.setCode(RetCode.SUCCESS.toString());
        return sd;
    }


}
