package com.wx.appbackend.doublecolor.controller;

import com.wx.appbackend.common.ServiceData;
import com.wx.appbackend.doublecolor.entity.BallNumbersReqDTO;
import com.wx.appbackend.doublecolor.entity.BallNumbersResDTO;
import com.wx.appbackend.doublecolor.entity.GenerateNumReqDTO;
import com.wx.appbackend.doublecolor.service.DoubleColorServiceImpl;
import com.wx.appbackend.test.CellInfo;
import com.wx.appbackend.doublecolor.entity.BallNumbers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/doublecolor")
public class DoubleColorController {

    @Autowired
    private DoubleColorServiceImpl doubleColorService;

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

    @RequestMapping("/bigfun")
    public void bigfun() throws Exception {
        List<BallNumbers> list = new ArrayList<>();
        int count = 0;
        int count1 = 0;
        long count2 = 1;
        for (int i = 1; i < 32; i++) {
            for (int j = i+1; j < 33; j++) {
                for (int k = j+1; k < 34; k++) {
                    for (int l = k+1; l < 35; l++) {
                        for (int m = l+1; m < 36; m++) {
                            for (int n = 1; n < 12; n++) {
                                for (int o = n+1; o < 13; o++) {
                                    list.add(new BallNumbers());
                                    list.get(count).id = count2;
                                    list.get(count).number1 = i;
                                    list.get(count).number2 = j;
                                    list.get(count).number3 = k;
                                    list.get(count).number4 = l;
                                    list.get(count).number5 = m;
                                    list.get(count).number6 = n;
                                    list.get(count).number7 = o;
                                    count++;
                                    count2++;
                                    if (list.size()%3000 == 0) {
                                        System.out.println("写入第"+count1+"个文件");
                                        count1++;
                                        doubleColorService.insertBigFunBatch(list);
                                        list.clear();
                                        count = 0;
                                    }

                                }
                            }
                        }
                    }
                }
            }
        }
        if (list.size() > 0) {
            doubleColorService.insertBigFunBatch(list);
        }

    }

    @RequestMapping("/doublecolor")
    public void doubleColor() throws Exception {
        List<BallNumbers> list = new ArrayList<>();
        int count = 0;
        int count1 = 0;
        long count2 = 1;
        for (int i = 1; i < 29; i++) {
            for (int j = i+1; j < 30; j++) {
                for (int k = j+1; k < 31; k++) {
                    for (int l = k+1; l < 32; l++) {
                        for (int m = l+1; m < 33; m++) {
                            for (int n = m+1; n < 34; n++) {
                                for (int o = 1; o < 17; o++) {
                                    list.add(new BallNumbers());
                                    list.get(count).id = count2;
                                    list.get(count).number1 = i;
                                    list.get(count).number2 = j;
                                    list.get(count).number3 = k;
                                    list.get(count).number4 = l;
                                    list.get(count).number5 = m;
                                    list.get(count).number6 = n;
                                    list.get(count).number7 = o;
                                    count++;
                                    count2++;
                                    if (list.size()%3000 == 0) {
                                        System.out.println("写入第"+count1+"个文件");
                                        count1++;
                                        doubleColorService.insertBatch1(list);
                                        list.clear();
                                        count = 0;
                                    }

                                }
                            }
                        }
                    }
                }
            }
        }
        if (list.size() > 0) {
            doubleColorService.insertBatch1(list);
        }

    }

    @GetMapping("/get")
    public BallNumbers getById() throws Exception {
        BallNumbers ballNumber = doubleColorService.getById(1L);
        return ballNumber;
    }

    @PostMapping("/getByKeys")
    public List<BallNumbersResDTO> getByKeys(@RequestBody BallNumbersReqDTO reqDTO) throws Exception {
        List<BallNumbersResDTO> ballNumbers = doubleColorService.getByKeys(reqDTO);
        return ballNumbers;
    }

    @PostMapping("/getByKeys1")
    public List<BallNumbersResDTO> getByKeys1(@RequestBody BallNumbersReqDTO reqDTO) throws Exception {
        List<BallNumbersResDTO> ballNumbers = doubleColorService.getByKeys1(reqDTO);
        return ballNumbers;
    }

    @PostMapping("/getByIds")
    public List<BallNumbersResDTO> getByIds(@RequestBody BallNumbersReqDTO reqDTO) throws Exception {
        List<BallNumbersResDTO> ballNumbers = doubleColorService.getByIds(reqDTO);
        return ballNumbers;
    }

    @GetMapping("/generate")
    public List<int[]> generate(@RequestParam("size") int size) throws Exception {
        List<int[]> ballNumbers = doubleColorService.generate(size);
        return ballNumbers;
    }

    @PostMapping("/generateByParas")
    public List<int[]> generateByParas(@RequestBody BallNumbersReqDTO reqDTO) throws Exception {
        List<int[]> ballNumbers = doubleColorService.generateByParas(reqDTO);
        return ballNumbers;
    }

    @PostMapping("/generateBigFun")
    public String generateBigFun(@RequestBody BallNumbersReqDTO reqDTO) throws Exception {
        return doubleColorService.generateBigFun(reqDTO);

    }

    @PostMapping("/generateByParas1")
    public List<int[]> generateByParas1(@RequestBody BallNumbersReqDTO reqDTO) throws Exception {
        List<int[]> ballNumbers = doubleColorService.generateByParas1(reqDTO);
        return ballNumbers;
    }

    @GetMapping("/getLastTimes")
    public void getLastTimes() throws Exception {
        doubleColorService.getLastTimes();
    }

}
