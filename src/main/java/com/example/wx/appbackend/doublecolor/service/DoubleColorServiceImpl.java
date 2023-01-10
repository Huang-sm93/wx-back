package com.example.wx.appbackend.doublecolor.service;

import com.example.wx.appbackend.doublecolor.entity.GenerateNumReqDTO;
import com.example.wx.appbackend.doublecolor.util.CalculateUtility;
import com.example.wx.appbackend.test.CellInfo;
import com.example.wx.appbackend.test.ReadExcelUtility;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DoubleColorServiceImpl implements DoubleColorService {

    @Override
    public List<CellInfo> getPage(Map<String, Object> map) {
        return ReadExcelUtility.getArrFileName("历史记录.xls",0, 10);
    }

    @Override
    public List<int[]> generateByPara(GenerateNumReqDTO reqDTO) {
        return CalculateUtility.getListByPara(reqDTO);
    }
}
