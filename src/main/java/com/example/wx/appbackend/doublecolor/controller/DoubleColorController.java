package com.example.wx.appbackend.doublecolor.controller;

import com.example.wx.appbackend.common.ServiceData;
import com.example.wx.appbackend.doublecolor.service.DoubleColorService;
import com.example.wx.appbackend.test.CellInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/doublecolor")
public class DoubleColorController {

    @Autowired
    private DoubleColorService doubleColorService;

    @PostMapping("/getpage")
    public ServiceData<List<CellInfo>> getUser(@RequestBody Map<String, Object> map)throws Exception{
        ServiceData sd = new ServiceData();
        sd.setBo(doubleColorService.getPage(map));
        return sd;
    }

}
