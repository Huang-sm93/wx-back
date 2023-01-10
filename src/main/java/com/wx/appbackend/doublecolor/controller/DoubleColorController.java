package com.wx.appbackend.doublecolor.controller;

import com.wx.appbackend.common.ServiceData;
import com.wx.appbackend.doublecolor.entity.GenerateNumReqDTO;
import com.wx.appbackend.doublecolor.service.DoubleColorService;
import com.wx.appbackend.test.CellInfo;
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

    //根据条件生成接口
    @PostMapping("/generatebypara")
    public ServiceData<List<CellInfo>> generateByPara(@RequestBody GenerateNumReqDTO reqDTO)throws Exception{
        ServiceData sd = new ServiceData();
        sd.setBo(doubleColorService.generateByPara(reqDTO));
        return sd;
    }

}
