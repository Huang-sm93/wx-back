package com.wx.appbackend.controller;

import com.wx.appbackend.common.RetCode;
import com.wx.appbackend.common.ServiceData;
import com.wx.appbackend.service.myaccount.entity.AccountReqDTO;
import com.wx.appbackend.service.myaccount.entity.AccountResDTO;
import com.wx.appbackend.service.myaccount.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Map;

@RestController
@RequestMapping(value = "/account")
public class MyAccountController {

    @Autowired
    private AccountServiceImpl service;

    @PostMapping("/getpage")
    public ServiceData<String> getUser(@RequestBody Map<String, Object> map)throws Exception{
        ServiceData sd = new ServiceData();

        return sd;
    }

    @PostMapping("/insert")
    public ServiceData<Integer> insert(@RequestBody AccountReqDTO reqDTO)throws Exception{
        ServiceData sd = new ServiceData();
        sd.setBo(service.insert(reqDTO));
        sd.setCode(RetCode.SUCCESS.toString());
        return sd;
    }

    @PostMapping("/update")
    public ServiceData<Integer> update(@RequestBody AccountReqDTO reqDTO)throws Exception{
        ServiceData sd = new ServiceData();
        service.update(reqDTO);
        sd.setCode(RetCode.SUCCESS.toString());
        return sd;
    }

    @GetMapping("/get")
    public ServiceData<AccountResDTO> get(@PathParam("id") Long id)throws Exception{
        ServiceData sd = new ServiceData();
        service.selectById(id);
        sd.setCode(RetCode.SUCCESS.toString());
        return sd;
    }


}
