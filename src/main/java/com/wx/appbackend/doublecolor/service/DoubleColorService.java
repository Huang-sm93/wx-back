package com.wx.appbackend.doublecolor.service;

import com.wx.appbackend.doublecolor.entity.BallNumbersReqDTO;
import com.wx.appbackend.doublecolor.entity.BallNumbersResDTO;
import com.wx.appbackend.doublecolor.entity.GenerateNumReqDTO;
import com.wx.appbackend.test.CellInfo;
import com.wx.appbackend.doublecolor.entity.BallNumbers;
import jxl.write.WriteException;

import java.io.IOException;
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

    int insertBigFunBatch(List<BallNumbers> list) throws Exception;

    int insertBatch1(List<BallNumbers> list) throws Exception;

    BallNumbers getById(long l);

    List<BallNumbersResDTO> getByKeys(BallNumbersReqDTO reqDTO);

    List<BallNumbersResDTO> getByKeys1(BallNumbersReqDTO reqDTO);

    List<BallNumbersResDTO> getByIds(BallNumbersReqDTO reqDTO);

    List<int[]> generate(int size);

    List<int[]> generateByParas(BallNumbersReqDTO reqDTO) throws WriteException, IOException;
    List<int[]> generateByParas1(BallNumbersReqDTO reqDTO) throws WriteException, IOException;

    void getLastTimes() throws WriteException, IOException;

    String generateBigFun(BallNumbersReqDTO reqDTO) throws WriteException, IOException;

    String generateBigFunRed(BallNumbersReqDTO reqDTO) throws WriteException, IOException;

    void insertBFRBatch(List<BallNumbers> list);

    String generateDCRed(BallNumbersReqDTO reqDTO) throws WriteException, IOException;

    void calculateBFIndex() throws WriteException, IOException;
}
