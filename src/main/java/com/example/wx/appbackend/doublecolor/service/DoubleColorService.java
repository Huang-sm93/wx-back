package com.example.wx.appbackend.doublecolor.service;

import com.example.wx.appbackend.doublecolor.entity.GenerateNumReqDTO;
import com.example.wx.appbackend.test.CellInfo;

import java.util.List;
import java.util.Map;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2022/8/19
 */
public interface DoubleColorService {

    List<CellInfo> getPage(Map<String, Object> map);

    List<int[]> generateByPara(GenerateNumReqDTO reqDTO);
}
